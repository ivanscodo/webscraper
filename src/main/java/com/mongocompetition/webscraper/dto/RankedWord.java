package com.mongocompetition.webscraper.dto;

public class RankedWord {

    private String word;
    private Long ocurrences;

    public RankedWord(String word, Long ocurrences) {
        this.word = word;
        this.ocurrences = ocurrences;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Long getOcurrences() {
        return ocurrences;
    }

    public void setOcurrences(Long ocurrences) {
        this.ocurrences = ocurrences;
    }
}
