package com.example.tlanguage.viewmodel;

import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.tlanguage.R;

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
        switch (view.getId()) {
            case R.id.btnMainHeaderAdd:
                PopupMenu popupMenu = new PopupMenu(mContext,view);
                popupMenu.getMenuInflater().inflate(R.menu.header_more_menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(mContext,"You clicked" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                popupMenu.show();
        }
    }
}
