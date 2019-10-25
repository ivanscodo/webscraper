package com.mongocompetition.webscraper.service;

import com.mongocompetition.webscraper.dto.RankedWord;
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
import java.util.ArrayList;
import java.util.List;

@Component
@RequestScope
public class CrawlerProcessor {
    @Value("${headless}")
    private boolean headless;
    private WebDriver webDriver;

    public void setUpWebDriver() {
        final String chromePath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1024x768");
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
        return parseHTML(webDriver.getPageSource(), url);
    }

    public WebSite parseHTML(final String html, final String url) {
        final Document document = Jsoup.parse(html);

        WebSite webSite = new WebSite();
        webSite.setHtmlContent(document.toString());
        webSite.setTextContent(document.text());
        webSite.setTitle(document.title());
        webSite.setUrl(url);

        webSite.setLanguage(document.getElementsByTag("head").stream()
                .map(s -> s.attr("lang"))
                .findFirst()
                .orElse("No language found."));
        webSite.setRankedWords(extractAndRankWords(document));
        return webSite;
    }

    public List<RankedWord> extractAndRankWords(Document document){
        List<RankedWord> result = new ArrayList<>();
        result.add(new RankedWord("test1", 10));
        result.add(new RankedWord("test2", 9));
        return result;
    }

    @PreDestroy
    public void closeBrowser() {
        webDriver.close();
    }
}
