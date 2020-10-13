package com.laam.laamnotes.presentation.util.binding

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter

object ImageViewBinding {

    @JvmStatic
    @BindingAdapter("imagePath")
    fun bindImagePath(imageView: ImageView, path: String?) {
        path?.let {
            imageView.setImageURI(Uri.parse(path))
        }
    }
}