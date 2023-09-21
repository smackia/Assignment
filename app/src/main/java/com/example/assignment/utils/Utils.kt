package com.example.assignment.utils

import android.app.Activity
import android.content.Context
import android.widget.Toast

class Utils {
    companion object {

        fun showToast(context: Context, msg: String) {
            if (!(context as Activity).isDestroyed && !context.isFinishing) {
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
            }
        }
    }

}