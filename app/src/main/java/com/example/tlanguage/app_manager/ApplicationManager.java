package com.example.tlanguage.app_manager;

import android.content.Context;

public class ApplicationManager {
    private static Context mApplicationContext, mContext;
    private static ApplicationManager instant;

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

    public Context getApplicationContent() {
        return this.mApplicationContext;
    }
}
