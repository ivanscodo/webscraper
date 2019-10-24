package com.mongocompetition.webscraper.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CrawlerProcessor {
    @Value("${headless}")
    private boolean headless;
    private WebDriver webDriver;

    public void setUpWebDriver(){
        final String chromePath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
        //final String chromeDriverPath = System.getProperty("user.dir");
        //System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1024x768");
        options.setAcceptInsecureCerts(true);

        if(headless){
            options.addArguments("--no-sandbox");
            options.setHeadless(headless);
            options.addArguments("--disable-gpu");
        }

        options.setBinary(chromePath);
        webDriver = new ChromeDriver(options);
    }

    public String proccessUrl(final String url) {
        setUpWebDriver();
        webDriver.get(url);
        return "content after proccessing";
    }
}
