package com.mongocompetition.webscraper.controller;

import com.mongocompetition.webscraper.model.WebSite;
import com.mongocompetition.webscraper.service.WebCrawlerService;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/webscraper")
public class WebScraperController {

    private final WebCrawlerService webCrawlerService;

    public WebScraperController(WebCrawlerService webCrawlerService) {
        this.webCrawlerService = webCrawlerService;
    }

    @GetMapping
    @ResponseBody
    public List<WebSite> findAll(){
        return webCrawlerService.findAll();
    }

    @PostMapping(produces = "application/json", consumes = {"text/html", "application/x-www-form-urlencoded"})
    public String createFromHtml(MultiValueMap<String,String>  createRequestDTO){
        Map<String,String> parameters = createRequestDTO.toSingleValueMap();
        return webCrawlerService.create(parameters.get("url"));
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public String createFromJson(@RequestBody CreateRequestDTO createRequestDTO){
        return webCrawlerService.create(createRequestDTO.getUrl());
    }

}
