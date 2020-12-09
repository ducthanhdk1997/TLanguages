package com.example.tlanguage.app_manager;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

public class TLanguageSizeDataManager extends AbstractAppManager {
    private int mHeight;
    private int mWidth;
    private boolean landscapeMode = false;
    private static TLanguageSizeDataManager instance;
    private Display mDisplay;

    private TLanguageSizeDataManager() {
        super();
        Context context = ApplicationManager.getInstance().getApplicationContent();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        mDisplay = windowManager.getDefaultDisplay();
        init();
    }


    public static TLanguageSizeDataManager getInstance() {
        if (instance == null) {
            instance = new TLanguageSizeDataManager();
        }
        return instance;
    }

    private void setWithAndHeight() {
        Point size = new Point();
        mDisplay.getSize(size);
        mWidth = size.x;
        mHeight = size.y;
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    private void setLandscapeMode() {
        landscapeMode = mWidth > mHeight;
        Log.d("ducthanh", toString());
    }

    public void init() {
        setWithAndHeight();
        setLandscapeMode();
    }

    public boolean isLandscapeMode() {
        return landscapeMode;
    }

    public String toString() {
        return "Height: " + getHeight() + "\n Width: " + getWidth() + "\n LandscapeMode: " + isLandscapeMode();
    }

    public int getHeaderAppbarHeight() {
        return (int) (mHeight * 0.3);
    }

    @Override
    protected void onInit() {
        init();
    }

}
