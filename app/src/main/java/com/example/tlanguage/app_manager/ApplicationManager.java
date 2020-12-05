package com.example.tlanguage.app_manager;

import android.content.Context;

public class ApplicationManager {
    private static Context mContext;
    private static ApplicationManager instant;

    private ApplicationManager() {

    }

    public static ApplicationManager getInstance() {
        if (instant == null) {
            instant = new ApplicationManager();
        }
        return instant;
    }

    public void setApplicationContext(Context context) {
        this.mContext = context;
    }

    public Context getApplicationContent() {
        return this.mContext;
    }
}
