package com.example.tlanguage.viewmodel;

import com.example.tlanguage.model.Language;

import java.util.ArrayList;
import java.util.List;

public class LanguageFragmentViewModel extends AbstractViewModel {
    private List<Language> languages;
    public LanguageFragmentViewModel() {
        languages = new ArrayList<>();
        initData();
    }

    private void initData() {
        Language language = new Language(1,"English");
        Language language1 = new Language(1,"Japan");
        Language language2 = new Language(1,"Korea");
        languages.add(language);
        languages.add(language1);
        languages.add(language2);
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
}
