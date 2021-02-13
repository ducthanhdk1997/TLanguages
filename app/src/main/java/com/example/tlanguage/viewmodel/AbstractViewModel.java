package com.example.tlanguage.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.tlanguage.app_manager.ApplicationManager;
import com.example.tlanguage.app_manager.TLanguageSizeDataManager;

public abstract class AbstractViewModel extends BaseObservable implements ViewModelAction{

    protected TLanguageSizeDataManager mTLanguageSizeDataManager = TLanguageSizeDataManager.getInstance();
    protected Context mContext = ApplicationManager.getInstance().getApplicationContext();
    private int appbarHeight;

    public AbstractViewModel() {
        setAppbarHeight();
    }

    @Bindable
    public int getAppbarHeight() {
        return appbarHeight;
    }

    public void setAppbarHeight() {
        appbarHeight = mTLanguageSizeDataManager.getHeaderAppbarHeight();
        notifyChange();
    }

    public void invalidate() {
        onInit();
    }

    protected abstract void onInit();



}
