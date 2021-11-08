package com.jedun.fretollochallenge.presentation.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

class BindingAdapters {

    /**
     * Binding adapter to bind image resource to imageview
     */
    @BindingAdapter("imageResource")
    fun setImageViewResource(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource)
    }

}