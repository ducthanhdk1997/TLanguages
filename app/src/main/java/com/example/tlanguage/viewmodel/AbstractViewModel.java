package com.example.tlanguage.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Observable;

public class AbstractViewModel extends BaseObservable {

    public void onInit() {
        notifyChange();
    }

}
