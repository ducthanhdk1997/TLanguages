package com.example.tlanguage.viewmodel;

import android.util.Log;
import android.view.View;

import androidx.databinding.Bindable;

import com.example.tlanguage.R;

public class HeaderFragmentViewModel extends AbstractViewModel {
    private String mContent;

    public HeaderFragmentViewModel() {

    }


    @Bindable
    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        this.mContent = content;
        notifyChange();
    }

    public void onItemsClick(View view) {

    }


}
