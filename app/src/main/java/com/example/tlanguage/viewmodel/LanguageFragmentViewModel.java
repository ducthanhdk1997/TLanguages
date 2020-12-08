package com.example.tlanguage.viewmodel;

import android.view.View;

import androidx.annotation.NonNull;

import com.example.tlanguage.model.Language;

import java.util.ArrayList;
import java.util.List;

public class LanguageFragmentViewModel extends AbstractViewModel {
    private List<Language> languages;
    public LanguageFragmentViewModel() {
        languages = new ArrayList<>();
        initData();
    }

    @Override
    public void onInit() {

    }

    private void initData() {
        Language language = new Language(1,"English");
        Language language1 = new Language(2,"Japan");
        Language language2 = new Language(3,"Korea");
        Language language3 = new Language(4,"MongKo");
        Language language4 = new Language(5,"China");
        Language language5 = new Language(6,"Russia");
        languages.add(language);
        languages.add(language1);
        languages.add(language2);
        languages.add(language3);
        languages.add(language4);
        languages.add(language5);
        languages.add(language);
        languages.add(language1);
        languages.add(language2);
        languages.add(language3);
        languages.add(language4);
        languages.add(language5);
    }

    public Language getLanguageWithPosition(int position) {
        if (languages != null && position < languages.size()) {
            return languages.get(position);
        }
        return null;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    @Override
    public void onClick(@NonNull View view) {

    }
}
