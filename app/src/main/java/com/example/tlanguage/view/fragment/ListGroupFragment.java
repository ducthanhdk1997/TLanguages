package com.example.tlanguage.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tlanguage.R;
import com.example.tlanguage.action.ItemListener;
import com.example.tlanguage.view.activity.WordsActivity;
import com.example.tlanguage.adapter.MyItemGroupRecyclerViewAdapter;
import com.example.tlanguage.databinding.FragmentListGroupListBinding;
import com.example.tlanguage.viewmodel.ListGroupViewModel;

/**
 * A fragment representing a list of Items.
 */
public class ListGroupFragment extends Fragment implements ItemListener {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private ListGroupViewModel mListGroupViewModel;
    private FragmentListGroupListBinding mBinding;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListGroupFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ListGroupFragment newInstance(int columnCount) {
        ListGroupFragment fragment = new ListGroupFragment();
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
        mListGroupViewModel = new ListGroupViewModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_group_list, container, false);
        mBinding.setViewModel(mListGroupViewModel);
        View view = mBinding.getRoot();

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyItemGroupRecyclerViewAdapter(mListGroupViewModel.getGroups(), this));
        }
        return view;
    }

    @Override
    public void itemClick(View view, int position) {
        Intent intent = new Intent(getContext(), WordsActivity.class);
        startActivity(intent);
    }

    @Override
    public void itemLongClick(View view, int position) {

    }
}