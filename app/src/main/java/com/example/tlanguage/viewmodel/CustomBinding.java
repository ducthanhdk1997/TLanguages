package com.example.tlanguage.viewmodel;

import android.view.View;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.BindingAdapter;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class CustomBinding {

    @BindingAdapter("loadHeight")
    public static void setLayoutHeight(AppBarLayout view, int height) {
        if (view.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
            params.height = height;
            view.setLayoutParams(params);
        } else {
            if (view.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams) {
                CollapsingToolbarLayout.LayoutParams params = (CollapsingToolbarLayout.LayoutParams) view.getLayoutParams();
                params.height = height;
                view.setLayoutParams(params);
            }
        }
    }

    @BindingAdapter("setWidth")
    public static void setWidth(View view, int width) {
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        params.width = width;
        view.setLayoutParams(params);
    }
}
