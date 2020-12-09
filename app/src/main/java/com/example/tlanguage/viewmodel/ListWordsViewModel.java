package com.example.tlanguage.viewmodel;

import android.view.View;

import androidx.annotation.NonNull;

import com.example.tlanguage.model.Word;

import java.util.ArrayList;
import java.util.List;

public class ListWordsViewModel extends AbstractViewModel {
    private List<Word> words;

    public ListWordsViewModel() {
        super();
        words = new ArrayList<>();
        initData();
    }

    private void initData() {
        Word word1 = new Word(1,"Hello", "Xin chao");
        Word word2 = new Word(2,"Hi", "Chao");
        Word word3 = new Word(3,"Pass", "Thong qua");
        Word word4 = new Word(4,"Word", "Tu");
        Word word5 = new Word(5,"Mean", "Nghia");
        Word word6 = new Word(6,"Agree", "Dong y");
        Word word7 = new Word(7,"Agreement", "Su dong y");
        Word word8 = new Word(8,"Effect", "Hieu qua");
        Word word9 = new Word(8,"Design", "Thiet ke");
        Word word10 = new Word(10,"Eys", "Mat");

        words.add(word1);
        words.add(word2);
        words.add(word3);
        words.add(word4);
        words.add(word5);
        words.add(word6);
        words.add(word7);
        words.add(word8);
        words.add(word9);
        words.add(word10);
    }

    public List<Word> getWords() {
        return words;
    }

    public Word getWord(int position) {
        return words.get(position);
    }

    @Override
    protected void onInit() {

    }

    @Override
    public void onClick(@NonNull View view) {

    }
}
