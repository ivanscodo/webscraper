package com.mongocompetition.webscraper.dto;

import com.mongocompetition.webscraper.model.RankedWord;

import java.util.ArrayList;
import java.util.List;

public class CreateResponseDTO {

    private String url;
    private String language;
    private String title;
    private List<RankedWord> rankedWords = new ArrayList<>();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public List<RankedWord> getRankedWords() {
        return rankedWords;
    }

    public void setRankedWords(List<RankedWord> rankedWords) {
        this.rankedWords = rankedWords;
    }

    public static final class Builder {
        private String url;
        private String language;
        private String title;
        private List<RankedWord> rankedWords = new ArrayList<>();

        private Builder() {
        }

        public static Builder aCreateResponseDTO() {
            return new Builder();
        }

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder withLanguage(String language) {
            this.language = language;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withRankedWords(List<RankedWord> rankedWords) {
            this.rankedWords = rankedWords;
            return this;
        }

        public CreateResponseDTO build() {
            CreateResponseDTO createResponseDTO = new CreateResponseDTO();
            createResponseDTO.setUrl(url);
            createResponseDTO.setLanguage(language);
            createResponseDTO.setTitle(title);
            createResponseDTO.setRankedWords(rankedWords);
            return createResponseDTO;
        }
    }
}
