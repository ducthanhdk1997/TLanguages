package com.example.tlanguage.activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tlanguage.R;
import com.example.tlanguage.app_manager.AbstractAppManager;
import com.example.tlanguage.app_manager.ApplicationManager;
import com.example.tlanguage.app_manager.TLanguageSizeDataManager;
import com.example.tlanguage.databinding.ActivityMainBinding;
import com.example.tlanguage.fragment.LanguageFragment;
import com.example.tlanguage.viewmodel.AbstractViewModel;
import com.example.tlanguage.viewmodel.MainActivityViewModel;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private Fragment mContentFragment;
    private FragmentManager mFragmentManager;
    private ApplicationManager mApplicationManager;
    private TLanguageSizeDataManager mTLanguageSizeDataManager;
    private MainActivityViewModel mMainActivityViewModel;
    private ActivityMainBinding mMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mApplicationManager = ApplicationManager.getInstance();
        mApplicationManager.setApplicationContext(getApplicationContext(), this);
        mTLanguageSizeDataManager = TLanguageSizeDataManager.getInstance();
        mMainActivityViewModel = new MainActivityViewModel();
        mMainBinding.setViewModel(mMainActivityViewModel);

        inti();
    }

    private void inti() {

        final CollapsingToolbarLayout collapsingToolbarLayout = mMainBinding.collpasingToolbarLayout;
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.personal_collapsed_title);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.personal_expanded_title);
        collapsingToolbarLayout.setCollapsedTitleTypeface(Typeface.DEFAULT_BOLD);
        collapsingToolbarLayout.setExpandedTitleGravity(Gravity.CENTER);
        collapsingToolbarLayout.setCollapsedTitleGravity(Gravity.START);

        mFragmentManager = getSupportFragmentManager();

        mContentFragment = LanguageFragment.newInstance(1);
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.mainContent,mContentFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTLanguageSizeDataManager.invalidate();
        mMainActivityViewModel.invalidate();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}