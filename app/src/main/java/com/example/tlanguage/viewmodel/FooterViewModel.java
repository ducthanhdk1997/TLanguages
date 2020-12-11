package com.example.tlanguage.viewmodel;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.Bindable;

import com.example.tlanguage.BR;
import com.example.tlanguage.R;
import com.example.tlanguage.app_manager.AppConstance;

public class FooterViewModel extends AbstractViewModel {

    @Bindable
    private int messageId;

    public FooterViewModel() {
        super();
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int message) {
        this.messageId = messageId;
    }

    @Override
    public void onInit() {
        notifyChange();
    }

    @Override
    public void onClick(@NonNull View view) {
        if (view.getId() == R.id.btnExercise) {
            messageId = AppConstance.START_EXERCISE_ACTIVITY;
            notifyPropertyChanged(BR.messageId);
        }
    }
}