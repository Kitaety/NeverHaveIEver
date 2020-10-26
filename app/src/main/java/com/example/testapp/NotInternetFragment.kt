package com.example.testapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.text.method.DialerKeyListener
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

class NotInternetFragment: DialogFragment() {
    companion object{
        var instance: Dialog? = null
        fun isOpen(): Boolean{
            return instance != null
        }

        fun show(supportFragmentManager:FragmentManager){
            NotInternetFragment().show(supportFragmentManager,"custom")
            Log.println(Log.WARN,"internet","open dialog window")
        }
        fun close(){
            instance?.dismiss()
            instance = null
            Log.println(Log.WARN,"internet","close dialog window")
        }
    }

    override
    fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(activity);

        builder.setView(R.layout.not_internet_fragment)

        var dialog = builder.create()
        dialog.setCanceledOnTouchOutside(false)
        dialog.window?.setBackgroundDrawableResource(R.color.transparent)
        dialog.setCancelable(false)
        dialog.setOnKeyListener(DialogInterface.OnKeyListener { dialog, keyCode, event -> keyCode == KeyEvent.KEYCODE_BACK  })
        NotInternetFragment.instance = dialog
        return dialog
    }
}



