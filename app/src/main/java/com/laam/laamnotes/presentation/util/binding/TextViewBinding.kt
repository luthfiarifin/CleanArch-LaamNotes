package com.laam.laamnotes.presentation.util.binding

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

object TextViewBinding {

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("formatNormalDate", "formatAddAttributeDate", requireAll = false)
    fun bindFormatNormalDate(textView: TextView, date: Long?, attribute: String?) {
        date?.let {
            val sdf = SimpleDateFormat("MM dd, HH:mm:ss", Locale.getDefault())
            textView.text = "$attribute${sdf.format(it)}"
        }
    }
}