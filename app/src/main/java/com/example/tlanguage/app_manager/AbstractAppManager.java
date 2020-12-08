package com.example.tlanguage.app_manager;

public abstract class AbstractAppManager {

    public void ApplicationManager() {

    }

    public void invalidate() {
        onInit();
    }

    protected abstract void onInit();
}
