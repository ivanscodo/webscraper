package com.mongocompetition.webscraper.dto;

public class CreateRequestDTO {
    private final String url;

    public CreateRequestDTO(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
