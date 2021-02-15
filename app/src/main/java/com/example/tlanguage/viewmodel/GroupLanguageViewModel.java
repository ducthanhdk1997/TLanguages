package com.example.tlanguage.viewmodel;

import android.view.View;

import androidx.annotation.NonNull;

import com.example.tlanguage.R;
import com.example.tlanguage.app_manager.DialogGroupManage;

public class GroupLanguageViewModel extends AbstractViewModel {
    private String appBarTitle = "English";

    public GroupLanguageViewModel() {
        super();
    }

    public String getAppBarTitle() {
        return appBarTitle;
    }

    @Override
    public void onInit() {
        notifyChange();
    }

    @Override
    public void onClick(@NonNull View view) {

    }
}
