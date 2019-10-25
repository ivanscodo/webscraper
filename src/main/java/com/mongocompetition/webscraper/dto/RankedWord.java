package com.mongocompetition.webscraper.dto;

public class RankedWord {

    private String word;
    private int ocurrences;

    public RankedWord(String word, int ocurrences) {
        this.word = word;
        this.ocurrences = ocurrences;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getOcurrences() {
        return ocurrences;
    }

    public void setOcurrences(int ocurrences) {
        this.ocurrences = ocurrences;
    }
}
