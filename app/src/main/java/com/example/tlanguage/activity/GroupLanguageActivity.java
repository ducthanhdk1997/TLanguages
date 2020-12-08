package com.example.tlanguage.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;

import com.example.tlanguage.app_constant.RequestCodeConstant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tlanguage.R;
import com.example.tlanguage.app_manager.TLanguageSizeDataManager;
import com.example.tlanguage.databinding.ActivityGroupLanguageBinding;
import com.example.tlanguage.fragment.FooterFragment;
import com.example.tlanguage.fragment.ListGroupFragment;
import com.example.tlanguage.viewmodel.GroupLanguageViewModel;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class GroupLanguageActivity extends AppCompatActivity {
    private Fragment mContentFragment, mFooterFragment;
    private FragmentManager mFaFragmentManager;
    Bundle mBundle;
    public String REQUEST_TITLE;
    private ActivityGroupLanguageBinding mBinding;
    private GroupLanguageViewModel mGroupViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_group_language);
        mGroupViewModel = new GroupLanguageViewModel();
        mBinding.setViewModel(mGroupViewModel);

        mBundle = getIntent().getExtras();
        assert mBundle != null;
        REQUEST_TITLE = mBundle.getString(RequestCodeConstant.REQUEST_TITLE);

        mFooterFragment = new FooterFragment();
        mContentFragment = ListGroupFragment.newInstance(1);
        mFaFragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = mFaFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.group_footer,mFooterFragment);
        fragmentTransaction.add(R.id.groupContent, mContentFragment);
        fragmentTransaction.commit();

        onInitCollapsingLayout();
    }

    private void onInitCollapsingLayout() {
        final CollapsingToolbarLayout collapsingToolbarLayout = mBinding.groupCollpasingToolbarLayout;
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.personal_collapsed_title);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.personal_expanded_title);
        collapsingToolbarLayout.setCollapsedTitleTypeface(Typeface.DEFAULT_BOLD);
        collapsingToolbarLayout.setExpandedTitleGravity(Gravity.CENTER);
        collapsingToolbarLayout.setCollapsedTitleGravity(Gravity.START);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGroupViewModel.onInit();
        TLanguageSizeDataManager.getInstance().init();
    }
}