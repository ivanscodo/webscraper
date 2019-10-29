package com.mongocompetition.webscraper.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class WebSite {

    @Id
    private String id;

    private String url;
    private String htmlContent;
    private String language;
    private String title;
    private String textContent;
    private List<RankedWord> rankedWords = new ArrayList<>();

    public List<RankedWord> getRankedWords() {
        return rankedWords;
    }

    public void setRankedWords(List<RankedWord> rankedWords) {
        this.rankedWords = rankedWords;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }
}
