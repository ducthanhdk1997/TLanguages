package com.example.tlanguage.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tlanguage.R;
import com.example.tlanguage.app_manager.AppConstance;
import com.example.tlanguage.databinding.ActivityWordsBinding;
import com.example.tlanguage.view.fragment.FooterFragment;
import com.example.tlanguage.view.fragment.HeaderFragment;
import com.example.tlanguage.view.fragment.ListWordsFragment;
import com.example.tlanguage.viewmodel.WordsActivityViewModel;

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

    @BindingAdapter({"showMessage"})
    public static void runMe(View view, int messageId) {
        if (messageId == AppConstance.START_EXERCISE_ACTIVITY) {
            view.getContext().startActivity(new Intent(view.getContext(), ExerciseActivity.class));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}