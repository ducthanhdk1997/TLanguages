package com.example.tlanguage.view.fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.tlanguage.R;
import com.example.tlanguage.app_manager.ApplicationManager;
import com.example.tlanguage.app_manager.DialogGroupManage;
import com.example.tlanguage.app_manager.DialogVocabularyManage;
import com.example.tlanguage.app_manager.PopupManage;
import com.example.tlanguage.view.activity.SettingsActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.example.tlanguage.app_constant.AppConstance;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HeaderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeaderFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private int ACTIVITY_CALL;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar mToolbar;
    private AppBarLayout appBarLayout;

    public HeaderFragment() {
        // Required empty public constructor
    }

    public static HeaderFragment newInstance(int activity) {
        HeaderFragment fragment = new HeaderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, activity);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ACTIVITY_CALL = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_header, container, false);
        collapsingToolbarLayout = view.findViewById(R.id.words_collpasing_toolbar_layout);
        initCollapsing();
        mToolbar = view.findViewById(R.id.header_toolbar);
        mToolbar.inflateMenu(R.menu.tool_bar_menu);
        appBarLayout = getActivity().findViewById(R.id.header);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isVisible = true;
            int scrollRange = -1;
            Menu menu = mToolbar.getMenu();

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    if (!isVisible) {
                        menu.clear();
                        mToolbar.inflateMenu(R.menu.toolbar_up);
                    }
                    isVisible = true;

                } else if (isVisible) {
                    if (isVisible) {
                        menu.clear();
                        mToolbar.inflateMenu(R.menu.tool_bar_menu);
                    }
                    isVisible = false;
                }
            }
        });
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuSetting:
                        Intent settingIntent = new Intent(getActivity(), SettingsActivity.class);
                        startActivity(settingIntent);
                        break;
                    case R.id.menuAdd:
                        actionAdd(view);
                        break;
                }
                return false;
            }
        });
        return view;
    }

    private void actionAdd(View view) {
        switch (ACTIVITY_CALL) {
            case AppConstance.START_MAIN_ACTIVITY:
                PopupManage popupManage = ApplicationManager.getInstance().getPopupManage();
                popupManage.createPopup(view, AppConstance.START_MAIN_ACTIVITY);
                break;
            case AppConstance.START_GROUP_ACTIVITY:
                DialogGroupManage dialogGroupManage = new DialogGroupManage();
                dialogGroupManage.show(getActivity().getSupportFragmentManager(),"Dialog Group");
                break;
            case AppConstance.START_VOCABULARY_ACTIVITY:
                DialogVocabularyManage dialogVocabularyManage = new DialogVocabularyManage();
                dialogVocabularyManage.show(getActivity().getSupportFragmentManager(), "Dialog Vocabulary");
        }
    }

    private void initCollapsing() {
        collapsingToolbarLayout.setTitleEnabled(true);
        collapsingToolbarLayout.setTitle("TEnglish");
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.personal_collapsed_title);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.personal_expanded_title);
        collapsingToolbarLayout.setCollapsedTitleTypeface(Typeface.DEFAULT_BOLD);
        collapsingToolbarLayout.setExpandedTitleGravity(Gravity.CENTER);
        collapsingToolbarLayout.setCollapsedTitleGravity(Gravity.START);
    }
}