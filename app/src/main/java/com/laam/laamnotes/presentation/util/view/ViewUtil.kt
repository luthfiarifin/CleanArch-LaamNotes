package com.laam.laamnotes.presentation.util.view

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

object ViewUtil {

    fun View.hideKeyboard(context: Context?) {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}