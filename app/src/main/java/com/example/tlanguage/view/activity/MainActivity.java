package com.example.tlanguage.view.activity;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceManager;

import com.example.tlanguage.R;
import com.example.tlanguage.app_constant.AppConstance;
import com.example.tlanguage.app_manager.ApplicationManager;
import com.example.tlanguage.app_manager.InterfaceActivity;
import com.example.tlanguage.app_manager.TLanguageSizeDataManager;
import com.example.tlanguage.databinding.ActivityMainBinding;
import com.example.tlanguage.setting.SettingDataManage;
import com.example.tlanguage.view.fragment.HeaderFragment;
import com.example.tlanguage.view.fragment.LanguageFragment;
import com.example.tlanguage.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity implements InterfaceActivity {
    private Fragment mContentFragment, mHeaderFragment;
    private FragmentManager mFragmentManager;
    private ApplicationManager mApplicationManager;
    private TLanguageSizeDataManager mTLanguageSizeDataManager;
    private MainActivityViewModel mMainActivityViewModel;
    private ActivityMainBinding mMainBinding;
    private SettingDataManage mSettingDataManage = SettingDataManage.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mApplicationManager = ApplicationManager.getInstance();
        mApplicationManager.setApplicationContext(getApplicationContext(), this);
        mTLanguageSizeDataManager = TLanguageSizeDataManager.getInstance();
        mMainActivityViewModel = new MainActivityViewModel();
        mMainBinding.setViewModel(mMainActivityViewModel);
        onInitFragment();
        onAttachFragment();
        updateSettingData();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void onInitFragment() {
        mFragmentManager = getSupportFragmentManager();
        mHeaderFragment = HeaderFragment.newInstance(AppConstance.START_MAIN_ACTIVITY);
        mContentFragment = LanguageFragment.newInstance(1);

    }

    private void onAttachFragment() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.header, mHeaderFragment);
        fragmentTransaction.add(R.id.mainContent, mContentFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTLanguageSizeDataManager.init();
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

    @Override
    public void updateSettingData() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean swap = sharedPreferences.getBoolean("swap_words", false);
        int repeat = Integer.parseInt(sharedPreferences.getString("repeat", "1"));
        boolean autoSpeckWord = sharedPreferences.getBoolean("auto_speak_words", false);
        mSettingDataManage.onUpdate(swap, repeat, autoSpeckWord);
    }
}