package com.example.tlanguage.viewmodel;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.example.tlanguage.app_constant.ExerciseConstants;
import com.example.tlanguage.app_manager.TLanguageSizeDataManager;
import com.example.tlanguage.view.size.ExerciseSize;

public class ChoosingViewModel extends AbstractViewModel {
    private ExerciseSize mExerciseSize;
    private int mItemAnswerHeight = 0;
    private int mItemAnswerWidth = 0;

    public ChoosingViewModel() {
        mExerciseSize = new ExerciseSize();
        onInit();
    }

    @Override
    protected void onInit() {
        setItemAnswerHeight();
        setAnswerWidth();
    }

    private void setAnswerWidth() {
        mItemAnswerWidth = mExerciseSize.getItemAnswerWidth();
        notifyChange();
    }

    private void setItemAnswerHeight() {
       mItemAnswerHeight = mExerciseSize.getItemAnswerHeight();
        notifyChange();
    }

    @Override
    public void onClick(@NonNull View view) {

    }

    @Bindable
    public int getItemAnswerHeight() {
        return mItemAnswerHeight;
    }

    @Bindable
    public int getItemAnswerWidth() {
        return mItemAnswerWidth;
    }

    @BindingAdapter({"height"})
    public static void itemHeight(TextView view, int height) {
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        params.height = height;
        view.setLayoutParams(params);
    }

    @BindingAdapter({"width"})
    public static void itemWidth(TextView view, int width) {
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        params.width = width;
        view.setLayoutParams(params);
    }


}
