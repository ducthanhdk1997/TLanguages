package com.example.tlanguage.activity;

import android.os.Bundle;

import com.example.tlanguage.app_constant.RequestCodeConstant;
import com.example.tlanguage.fragment.HeaderFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;

import com.example.tlanguage.R;

public class GroupLanguageActivity extends AppCompatActivity {
    private Fragment mHeaderFragment, mContentFragment, mFooterFragment;
    private FragmentManager mFaFragmentManager;
    Bundle mBundle;
    public String REQUEST_TITLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_language);
        mBundle = getIntent().getExtras();
        assert mBundle != null;
        REQUEST_TITLE = mBundle.getString(RequestCodeConstant.REQUEST_TITLE);
        mHeaderFragment = HeaderFragment.newInstance(REQUEST_TITLE);
        mFaFragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = mFaFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.group_language_headerLayout,mHeaderFragment);
        fragmentTransaction.commit();
    }
}