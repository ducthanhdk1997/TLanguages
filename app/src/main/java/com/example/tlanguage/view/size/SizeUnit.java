package com.example.tlanguage.view.size;

import android.content.Context;

import com.example.tlanguage.app_manager.ApplicationManager;
import com.example.tlanguage.app_manager.TLanguageSizeDataManager;

public class SizeUnit {
    protected TLanguageSizeDataManager mTLanguageSizeDataManager;
    protected Context mContext;

    protected SizeUnit() {
        mTLanguageSizeDataManager = TLanguageSizeDataManager.getInstance();
        mContext = ApplicationManager.getInstance().getContext();
    }

    protected int getDimensionPixelSize(int id) {
        int result = 0;
        try {
            result = mContext.getResources().getDimensionPixelSize(id);
        } catch (Exception ignored) {
        }
        return result;
    }
}
