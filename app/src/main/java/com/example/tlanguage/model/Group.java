package com.example.tlanguage.model;

public class Group {
    private int id;
    private String name;
    private int LanguageId;
    private int words;

    public Group(int id, String name, int languageId, int words) {
        this.id = id;
        this.name = name;
        LanguageId = languageId;
        this.words = words;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLanguageId() {
        return LanguageId;
    }

    public void setLanguageId(int languageId) {
        LanguageId = languageId;
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }
}
