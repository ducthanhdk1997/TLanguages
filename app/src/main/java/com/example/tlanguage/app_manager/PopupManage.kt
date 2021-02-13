package com.example.tlanguage.app_manager
import android.app.Dialog
import android.content.Context
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import com.example.tlanguage.R
import com.example.tlanguage.view.activity.GroupLanguageActivity

class PopupManage : PopupManageInterface {
    private val mContext = ApplicationManager.getInstance().applicationContext
    private object Holder {val INSTANCE = PopupManage()}

    companion object {
        @JvmStatic
        fun getInstance(): PopupManage {
            return Holder.INSTANCE
        }
    }

    override fun createPopup(view: View, activity: Int) {
        if (activity == AppConstance.START_MAIN_ACTIVITY) {
            val popupMenu = PopupMenu(mContext, view)
            popupMenu.inflate(R.menu.add_language_menu)
            popupMenu.show()
        }
    }


}