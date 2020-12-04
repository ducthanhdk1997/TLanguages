package com.example.tlanguage.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.tlanguage.AppManager.ApplicationManager;
import com.example.tlanguage.app_constant.RequestCodeConstant;
import com.example.tlanguage.fragment.HeaderFragment;
import com.example.tlanguage.R;
import com.example.tlanguage.fragment.LanguageFragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout mHeaderLayout, mContentLayout;
    private Fragment mHeaderFragment, mContentFragment;
    private FragmentManager mFragmentManager;
    private ApplicationManager mApplicationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mApplicationManager = ApplicationManager.getInstance();
        mApplicationManager.setApplicationContext(getApplicationContext());
        inti();
    }

    private void inti() {
        mHeaderLayout = findViewById(R.id.headerLayout);
        mContentLayout = findViewById(R.id.contentLayout);

        mHeaderFragment = HeaderFragment.newInstance(RequestCodeConstant.REQUEST_APP_NAME);
        mFragmentManager = getSupportFragmentManager();

        mContentFragment = LanguageFragment.newInstance(1);

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.headerLayout,mHeaderFragment);
        fragmentTransaction.add(R.id.contentLayout,mContentFragment);
        fragmentTransaction.commit();
    }
}