package com.mongocompetition.webscraper.model;

public class RankedWord {

    private String word;
    private Long numberOfOcurrences;

    public RankedWord(String word, Long numberOfOcurrences) {
        this.word = word;
        this.numberOfOcurrences = numberOfOcurrences;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Long getNumberOfOcurrences() {
        return numberOfOcurrences;
    }

    public void setNumberOfOcurrences(Long numberOfOcurrences) {
        this.numberOfOcurrences = numberOfOcurrences;
    }
}
