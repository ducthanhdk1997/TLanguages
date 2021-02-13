package com.example.tlanguage.viewmodel;

import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.tlanguage.R;
import com.example.tlanguage.app_manager.AppConstance;
import com.example.tlanguage.app_manager.ApplicationManager;
import com.example.tlanguage.app_manager.PopupManage;

public class MainActivityViewModel extends AbstractViewModel {

    public MainActivityViewModel() {
        super();
    }


    @Override
    public void onInit() {
        notifyChange();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fab_add_language) {
            PopupManage popupManage = ApplicationManager.getInstance().getPopupManage();
            popupManage.createPopup(view, AppConstance.START_MAIN_ACTIVITY);
        }
    }
}
