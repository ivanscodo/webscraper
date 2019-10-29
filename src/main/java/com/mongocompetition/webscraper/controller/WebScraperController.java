package com.mongocompetition.webscraper.controller;

import com.mongocompetition.webscraper.dto.CreateRequestDTO;
import com.mongocompetition.webscraper.dto.CreateResponseDTO;
import com.mongocompetition.webscraper.service.WebCrawlerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping("/webscraper")
@RequestScope
public class WebScraperController {

    private final WebCrawlerService webCrawlerService;

    public WebScraperController(WebCrawlerService webCrawlerService) {
        this.webCrawlerService = webCrawlerService;
    }

    @GetMapping
    @ResponseBody
    @CrossOrigin
    public List<CreateResponseDTO> findAll(){
        return webCrawlerService.findAll();
    }

    @PostMapping(produces = "application/json", consumes = {"text/html", "application/x-www-form-urlencoded"})
    @CrossOrigin
    public ResponseEntity<CreateResponseDTO> createFromHtml(@RequestParam("url") String url){
        Assert.notNull(url, "Url cannot be null.");
        Assert.isTrue(!StringUtils.isEmpty(url), "Url cannot be empty.");
        CreateResponseDTO createResponseDTO = webCrawlerService.create(url);
        return ResponseEntity.status(HttpStatus.OK).body(createResponseDTO);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseBody
    @CrossOrigin
    public ResponseEntity<CreateResponseDTO> createFromJson(@RequestBody CreateRequestDTO createRequestDTO){
        CreateResponseDTO createResponseDTO = webCrawlerService.create(createRequestDTO.getUrl());
        return ResponseEntity.status(HttpStatus.OK).body(createResponseDTO);
    }
}
