package com.example.tlanguage.viewmodel;

import android.content.Context;
import android.os.Build;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.databinding.Bindable;

import com.example.tlanguage.app_manager.ApplicationManager;
import com.example.tlanguage.R;

public class HeaderFragmentViewModel extends AbstractViewModel {
    private String mTitle;
    private Context mContext;

    public HeaderFragmentViewModel(Context context) {
        this.mContext = context;
    }

    @Bindable
    public String getContent() {
        return mTitle;
    }

    public void setContent(String content) {
        this.mTitle = content;
        notifyChange();
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void onItemsClick(View view) {
        switch (view.getId()) {
            case R.id.btnHeaderAdd:

                if (mContext == null) {
                    mContext = ApplicationManager.getInstance().getApplicationContent();
                }
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
