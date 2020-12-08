package com.example.tlanguage.fragment;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tlanguage.R;
import com.example.tlanguage.databinding.FooterFragmentBinding;
import com.example.tlanguage.viewmodel.FooterViewModel;

public class FooterFragment extends Fragment {

    private FooterViewModel mViewModel;
    private FooterFragmentBinding mBinding;


    public static FooterFragment newInstance() {
        return new FooterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.footer_fragment, container, false);
        mViewModel = new FooterViewModel();
        mBinding.setViewModel(mViewModel);

        return mBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.onInit();
    }
}