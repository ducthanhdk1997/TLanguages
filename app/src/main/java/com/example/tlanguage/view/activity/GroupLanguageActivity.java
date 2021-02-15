package com.example.tlanguage.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tlanguage.R;
import com.example.tlanguage.app_constant.RequestCodeConstant;
import com.example.tlanguage.app_constant.AppConstance;
import com.example.tlanguage.app_manager.DialogGroupManage;
import com.example.tlanguage.app_manager.TLanguageSizeDataManager;
import com.example.tlanguage.databinding.ActivityGroupLanguageBinding;
import com.example.tlanguage.view.fragment.FooterFragment;
import com.example.tlanguage.view.fragment.HeaderFragment;
import com.example.tlanguage.view.fragment.ListGroupFragment;
import com.example.tlanguage.viewmodel.GroupLanguageViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class GroupLanguageActivity extends AppCompatActivity implements DialogGroupManage.DialogGroupListener {
    private Fragment mHeaderFragment, mContentFragment, mFooterFragment;
    private FragmentManager mFaFragmentManager;
    private Bundle mBundle;
    public String REQUEST_TITLE;
    private ActivityGroupLanguageBinding mBinding;
    private GroupLanguageViewModel mGroupViewModel;
    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_group_language);
        mGroupViewModel = new GroupLanguageViewModel();
        mBinding.setViewModel(mGroupViewModel);
        floatingActionButton = mBinding.fabGroup;
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogGroupManage dialogGroupManage = new DialogGroupManage();
                dialogGroupManage.show(getSupportFragmentManager(),"New Group");
            }
        });

        mBundle = getIntent().getExtras();
        assert mBundle != null;
        REQUEST_TITLE = mBundle.getString(RequestCodeConstant.REQUEST_TITLE);

        onInitFragment();
        onAttachFragment();
    }

    private void onInitFragment() {
        mHeaderFragment = HeaderFragment.newInstance(AppConstance.START_GROUP_ACTIVITY);
        mFooterFragment = new FooterFragment();
        mContentFragment = ListGroupFragment.newInstance(1);
        mFaFragmentManager = getSupportFragmentManager();

    }

    @Override
    protected void onResume() {
        super.onResume();
        mGroupViewModel.onInit();
        TLanguageSizeDataManager.getInstance().init();
    }

    private void onAttachFragment() {
        FragmentTransaction fragmentTransaction = mFaFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.header, mHeaderFragment);
        fragmentTransaction.add(R.id.group_footer, mFooterFragment);
        fragmentTransaction.add(R.id.groupContent, mContentFragment);
        fragmentTransaction.commit();
    }

    @BindingAdapter({"showMessage"})
    public static void runMe(View view, int messageId) {
        if (messageId == AppConstance.START_EXERCISE_ACTIVITY) {
            view.getContext().startActivity(new Intent(view.getContext(), ExerciseActivity.class));
        }
    }

    @Override
    public void handleClickOK() {
        Log.d("ducthanh","ok");
        Toast.makeText(this,"ok", Toast.LENGTH_LONG).show();
    }
}