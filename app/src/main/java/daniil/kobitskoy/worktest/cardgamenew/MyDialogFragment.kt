package daniil.kobitskoy.worktest.cardgamenew

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MyDialogFragment() : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("AppsFlyer")
                .setMessage(App().returnAttribution( ).toString())
                .setPositiveButton("Закрыть") {
                        dialog, id ->  dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}