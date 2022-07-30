package com.example.archcomp.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.archcomp.R

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imageUrl: String?) {
    Glide.with(imgView.context)
        .load(imageUrl)
        .apply(
            RequestOptions()
                .placeholder(R.drawable.loading_img)
                .error(R.drawable.ic_broken_image)
        )
        .into(imgView)
}