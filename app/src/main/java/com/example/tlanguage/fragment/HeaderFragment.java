package com.example.tlanguage.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tlanguage.R;
import com.example.tlanguage.databinding.FragmentHeaderBinding;
import com.example.tlanguage.viewmodel.HeaderFragmentViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HeaderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeaderFragment extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_CONTENT = "content";


    private String mContent;
    private HeaderFragmentViewModel mHeaderFragmentViewModel;

    public HeaderFragment() {
       mHeaderFragmentViewModel = new HeaderFragmentViewModel();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param content Parameter 1.
     * @return A new instance of fragment HeaderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HeaderFragment newInstance(String content) {
        HeaderFragment fragment = new HeaderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CONTENT, content);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mContent = getArguments().getString(ARG_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentHeaderBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_header, container, false);
        binding.setViewModel(mHeaderFragmentViewModel);
        mHeaderFragmentViewModel.setContent(mContent);
        return binding.getRoot();

    }
}