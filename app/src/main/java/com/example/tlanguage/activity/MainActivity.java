package com.example.tlanguage.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.tlanguage.fragment.HeaderFragment;
import com.example.tlanguage.R;
import com.example.tlanguage.fragment.LanguageFragment;

public class MainActivity extends AppCompatActivity {
    FrameLayout mHeaderLayout, mContentLayout;
    Fragment mHeaderFragment, mContentFragment;
    FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inti();
    }

    private void inti() {
        mHeaderLayout = findViewById(R.id.headerLayout);
        mContentLayout = findViewById(R.id.contentLayout);

        mHeaderFragment = HeaderFragment.newInstance("TEnglish");
        mFragmentManager = getSupportFragmentManager();

        mContentFragment = LanguageFragment.newInstance(1);

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.headerLayout,mHeaderFragment);
        fragmentTransaction.add(R.id.contentLayout,mContentFragment);
        fragmentTransaction.commit();
    }
}