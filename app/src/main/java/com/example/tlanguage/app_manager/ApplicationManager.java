package com.example.tlanguage.app_manager;

import android.content.Context;

public class ApplicationManager {
    private static Context mApplicationContext, mContext;
    private static ApplicationManager instant;
    private static PopupManage mPopupManage;

    public ApplicationManager() {
       
    }

    public static ApplicationManager getInstance() {
        if (instant == null) {
            instant = new ApplicationManager();
        }
        return instant;
    }

    public void setApplicationContext(Context applicationContext, Context context) {
        this.mApplicationContext = applicationContext;
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public PopupManage getPopupManage() {
        if (mPopupManage == null) {
            mPopupManage = new PopupManage();
        }
        return mPopupManage;
    }
}
