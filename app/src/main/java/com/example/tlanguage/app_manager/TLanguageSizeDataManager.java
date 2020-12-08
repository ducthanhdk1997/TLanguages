package com.example.tlanguage.app_manager;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

public class TLanguageSizeDataManager extends AbstractAppManager{
    private static int mHeight;
    private static int mWidth;
    private static boolean landscapeMode = false;
    private static TLanguageSizeDataManager instance;

    private TLanguageSizeDataManager() {
        super();
        init();
    }


    public static TLanguageSizeDataManager getInstance() {
        if (instance == null) {
            instance = new TLanguageSizeDataManager();
        }
        return instance;
    }

    private void setWithAndHeight() {
        Context context = ApplicationManager.getInstance().getContext();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        mHeight = displayMetrics.heightPixels;
        mWidth = displayMetrics.widthPixels;
        Log.d("ducthanh", toString());
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    private void setLandscapeMode() {
        landscapeMode = mWidth > mHeight;
    }

    public void init() {
        setWithAndHeight();
        setLandscapeMode();
    }

    public boolean isLandscapeMode() {
        return landscapeMode;
    }

    public String toString() {
        return "Height: " + getHeight() +"\n Width: " + getWidth() + "\n LandscapeMode: " + isLandscapeMode();
    }

    public int getHeaderAppbarHeight() {
        return (int) (mHeight*0.3);
    }

    @Override
    protected void onInit() {
        init();
    }

}
