package com.example.tlanguage.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tlanguage.R;
import com.example.tlanguage.action.ItemListener;
import com.example.tlanguage.activity.GroupLanguageActivity;
import com.example.tlanguage.adapter.MyLanguageRecyclerViewAdapter;
import com.example.tlanguage.app_constant.RequestCodeConstant;
import com.example.tlanguage.databinding.FragmentItemListBinding;
import com.example.tlanguage.model.Language;
import com.example.tlanguage.viewmodel.LanguageFragmentViewModel;

public class LanguageFragment extends Fragment implements ItemListener {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private MyLanguageRecyclerViewAdapter mAdapter;
    private LanguageFragmentViewModel mLanguageFragmentViewModel;


    public LanguageFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static LanguageFragment newInstance(int columnCount) {
        LanguageFragment fragment = new LanguageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        mLanguageFragmentViewModel = new LanguageFragmentViewModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentItemListBinding fragmentItemListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_item_list,container,false);
        fragmentItemListBinding.setViewModel(mLanguageFragmentViewModel);
        View view = fragmentItemListBinding.getRoot();

        mAdapter = new MyLanguageRecyclerViewAdapter(mLanguageFragmentViewModel.getLanguages(),this);
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            }
            recyclerView.setAdapter(mAdapter);
        }
        return view;
    }

    @Override
    public void itemClick(View view, int position) {
        Language language = mLanguageFragmentViewModel.getLanguageWithPosition(position);
        Intent intent = new Intent(getContext(), GroupLanguageActivity.class);
        Bundle bundle = new Bundle();

        switch (language.getName()) {
            case "English":
                bundle.putString(RequestCodeConstant.REQUEST_TITLE, RequestCodeConstant.REQUEST_NAME_GROUP_ENGLISH);
                break;
            case "Korea":
                bundle.putString(RequestCodeConstant.REQUEST_TITLE, RequestCodeConstant.REQUEST_NAME_GROUP_KOREA);
                break;
            case "China":
                bundle.putString(RequestCodeConstant.REQUEST_TITLE, RequestCodeConstant.REQUEST_NAME_GROUP_CHINA);
                break;
            case "Japan":
                bundle.putString(RequestCodeConstant.REQUEST_TITLE, RequestCodeConstant.REQUEST_NAME_GROUP_JAPAN);
                break;
            default:
                break;
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void itemLongClick(View view, int position) {
        Toast.makeText(getContext(), "Position longClicked: " + position,Toast.LENGTH_SHORT).show();
    }
}