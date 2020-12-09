package com.example.tlanguage.model;

public class Word {
    private int id;
    private String word;
    private String mean;

    public Word(int id, String word, String mean) {
        this.id = id;
        this.word = word;
        this.mean = mean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }
}
