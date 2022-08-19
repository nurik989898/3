package com.example.youtubeapi2.di.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.youtubeapi2.model.Medium

fun ImageView.load(url: String?){
    Glide.with(context)
        .load(url)
        .into(this)
}