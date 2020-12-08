package com.example.tlanguage.viewmodel;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.Bindable;

import com.example.tlanguage.R;

public class FooterViewModel extends AbstractViewModel {
    private int mButtonWidth;

    public FooterViewModel() {
        super();
        setButtonWidth(mTLanguageSizeDataManager.getWidth());
    }

    @Bindable
    public int getButtonWidth() {
        return mButtonWidth;
    }

    public void setButtonWidth(int realScreanWidth) {
        this.mButtonWidth = (int) (realScreanWidth * 0.45);
        notifyChange();
    }
    @Override
    public void onInit() {
        setButtonWidth(mTLanguageSizeDataManager.getWidth());
        notifyChange();
    }

    @Override
    public void onClick(@NonNull View view) {
        switch (view.getId()) {
            case R.id.btnExercise:
                // your code
                break;
            case R.id.btnHardWord:
                // your code
                break;
        }
    }
    // TODO: Implement the ViewModel
}