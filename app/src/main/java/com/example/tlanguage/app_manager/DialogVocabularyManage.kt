package com.example.tlanguage.app_manager

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.tlanguage.R

class DialogVocabularyManage: DialogFragment() {
    private var editWord: EditText? = null
    private var editMean: EditText? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var alertDialog = AlertDialog.Builder(activity)
        var inflater = activity?.layoutInflater
        var view = inflater?.inflate(R.layout.add_vocabulary_dialog, null)

        alertDialog.setView(view)
                .setTitle("Add Vocabulary")
                .setNegativeButton("Cancel",
                        DialogInterface.OnClickListener { dialog, which ->
                            dialog.dismiss()

                        })
                .setPositiveButton("Ok",
                        DialogInterface.OnClickListener() { dialog, which ->
                        })
        editWord = view?.findViewById(R.id.edit_add_voc_word)
        editMean = view?.findViewById(R.id.edit_add_voc_mean)
        return alertDialog.create()
    }
}