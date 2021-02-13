package com.example.tlanguage.app_manager

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.tlanguage.R
import java.lang.ClassCastException

class DialogGroupManage : DialogFragment() {
    private var editNameGroup: EditText? = null
    private var listener: DialogGroupListener? =null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var alertDialog = AlertDialog.Builder(activity)
        var inflater = activity?.layoutInflater
        var view = inflater?.inflate(R.layout.layout_add_group, null)

        alertDialog.setView(view)
                .setTitle("Add Group")
                .setNegativeButton("Cancel",
                        DialogInterface.OnClickListener { dialog, which ->
                            dialog.dismiss()

                        })
                .setPositiveButton("Ok",
                        DialogInterface.OnClickListener() { dialog, which ->
                            listener?.handleClickOK()
                        })
        editNameGroup = view?.findViewById(R.id.edit_add_name_group)
        return alertDialog.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as DialogGroupListener
        } catch (e: ClassCastException) {
            throw  ClassCastException(context.toString() +
            "class must implement DialogGroupListener")
        }
    }

    interface DialogGroupListener {
        fun handleClickOK()
    }
}