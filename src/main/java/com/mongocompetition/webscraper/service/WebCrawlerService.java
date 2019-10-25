package com.mongocompetition.webscraper.service;

import com.mongocompetition.webscraper.dao.WebSiteRepository;
import com.mongocompetition.webscraper.model.WebSite;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebCrawlerService {

    private final CrawlerProcessor crawlerProcessor;
    private final WebSiteRepository webSiteRepository;

    public WebCrawlerService(CrawlerProcessor crawlerProcessor, WebSiteRepository webSiteRepository) {
        this.crawlerProcessor = crawlerProcessor;
        this.webSiteRepository = webSiteRepository;
    }

    public String create(final String url){
        final String jsonContent = crawlerProcessor.proccessUrl(url);
        WebSite webSite = new WebSite();
        webSite.setContent(jsonContent);
        webSite.setUrl(url);
        webSiteRepository.save(webSite);
        return jsonContent;
    }

    public List<WebSite> findAll(){
        return webSiteRepository.findAll();
    }


}
