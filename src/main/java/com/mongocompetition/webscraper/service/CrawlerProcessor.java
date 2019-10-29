package com.mongocompetition.webscraper.service;

import com.mongocompetition.webscraper.model.RankedWord;
import com.mongocompetition.webscraper.model.WebSite;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PreDestroy;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequestScope
public class CrawlerProcessor {

    @Value("${chrome.headless}")
    private boolean headless;

    @Value("${chrome.path}")
    private String chromePath;
    private WebDriver webDriver;

    public void setUpWebDriver() {

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        if (headless) {
            options.addArguments("--no-sandbox");
            options.setHeadless(headless);
            options.addArguments("--disable-gpu");
        }

        options.setBinary(chromePath);
        webDriver = new ChromeDriver(options);
    }

    public WebSite proccessUrl(final String url) {
        setUpWebDriver();
        webDriver.get(url);
        return createWebSiteObjectFromHTML(webDriver.getPageSource(), url);
    }

    public WebSite createWebSiteObjectFromHTML(final String html, final String url) {
        final Document document = Jsoup.parse(html);

        WebSite webSite = new WebSite();
        webSite.setHtmlContent(document.toString());
        webSite.setTextContent(document.text());
        webSite.setTitle(document.title());
        webSite.setUrl(url);
        webSite.setLanguage(getLanguage(document));
        webSite.setRankedWords(extractAndRankWords(webSite.getTextContent()));

        return webSite;
    }

    private String getLanguage(Document document) {
        return document.getElementsByTag("head").stream()
                .map(s -> s.attr("lang"))
                .findFirst()
                .orElse("No language found.");
    }

    private List<RankedWord> extractAndRankWords(final String textContent) {
        final Map<String, Long> wordCounter = new HashMap<>();

        Arrays.stream(textContent.split(" "))
                .filter(s -> s.length() > 3)
                .collect(Collectors.groupingBy(k -> k, () -> wordCounter, Collectors.counting()));

        return wordCounter.keySet()
                .stream()
                .map(s -> new RankedWord(s, wordCounter.get(s)))
                .sorted(Comparator.comparing(s -> s.getNumberOfOcurrences() * -1))
                .limit(50)
                .collect(Collectors.toList());
    }

    @PreDestroy
    public void closeBrowser() {
        webDriver.close();
    }
}
