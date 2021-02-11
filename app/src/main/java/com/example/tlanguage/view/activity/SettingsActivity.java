package com.example.tlanguage.view.activity;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import com.example.tlanguage.R;
import com.example.tlanguage.app_manager.InterfaceActivity;
import com.example.tlanguage.setting.SettingDataManage;

public class SettingsActivity extends AppCompatActivity implements InterfaceActivity {
    private SettingDataManage mSettingDataManage = SettingDataManage.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        updateSettingData();
    }

    @Override
    public void updateSettingData() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean swap = sharedPreferences.getBoolean("swap_words", false);
        int repeat = Integer.parseInt(sharedPreferences.getString("repeat", "1"));
        boolean autoSpeckWord = sharedPreferences.getBoolean("auto_speak_words", false);
        mSettingDataManage.onUpdate(swap, repeat, autoSpeckWord);
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }

        @Override
        public void onStop() {
            super.onStop();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
        }
    }
}