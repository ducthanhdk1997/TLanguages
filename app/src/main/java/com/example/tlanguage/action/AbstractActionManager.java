package com.example.tlanguage.action;

import android.view.MotionEvent;
import android.view.View;

public class AbstractActionManager implements View.OnTouchListener, View.OnLongClickListener{


    public AbstractActionManager() {
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                onDown();
                break;
            case MotionEvent.ACTION_UP:
                onUp();
                break;
            case MotionEvent.ACTION_MOVE:
                onMove();
                break;
        }
        return false;
    }

    public void onMove() {

    }

    public void onUp() {
    }

    public void onDown() {

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
