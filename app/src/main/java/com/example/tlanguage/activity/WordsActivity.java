package com.example.tlanguage.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;

import com.example.tlanguage.R;
import com.example.tlanguage.databinding.ActivityWordsBinding;
import com.example.tlanguage.fragment.FooterFragment;
import com.example.tlanguage.fragment.HeaderFragment;
import com.example.tlanguage.fragment.ListWordsFragment;
import com.example.tlanguage.viewmodel.WordsActivityViewModel;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class WordsActivity extends AppCompatActivity {
    private WordsActivityViewModel mViewModel;
    private ActivityWordsBinding mBinding;
    private Fragment listWordFragment, mFooterFragment, mHeaderFragment;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_words);
        mViewModel = new WordsActivityViewModel();
        mBinding.setViewModel(mViewModel);

        onInitFragment();
        onAttachFragment();
    }

    private void onAttachFragment() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.wordsContent, listWordFragment);
        fragmentTransaction.add(R.id.words_footer, mFooterFragment);
        fragmentTransaction.add(R.id.header, mHeaderFragment);
        fragmentTransaction.commit();
    }

    private void onInitFragment() {
        mFragmentManager = getSupportFragmentManager();
        listWordFragment = ListWordsFragment.newInstance(1);
        mFooterFragment = new FooterFragment();
        mHeaderFragment = new HeaderFragment();
    }
}