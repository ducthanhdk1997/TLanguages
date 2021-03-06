package com.example.tlanguage.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.tlanguage.R;
import com.example.tlanguage.databinding.FragmentChoosingBinding;
import com.example.tlanguage.viewmodel.ChoosingViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChoosingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChoosingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ChoosingViewModel mChoosingViewModel;
    private FragmentChoosingBinding mBinding;

    public ChoosingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChoosingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChoosingFragment newInstance(String param1, String param2) {
        ChoosingFragment fragment = new ChoosingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_choosing, container, false);
        View view = mBinding.getRoot();
        mChoosingViewModel = new ChoosingViewModel();
        mBinding.setViewModel(mChoosingViewModel);
        return view;
    }
}