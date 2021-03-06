package com.devtides.countries.util

import android.content.Context
import android.support.v4.widget.CircularProgressDrawable
import android.support.v4.widget.ContentLoadingProgressBar
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.devtides.countries.R
import io.reactivex.schedulers.Schedulers.start

fun getProgressDrawable(context: Context): ProgressBar {
    return ProgressBar(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

fun ImageView.loadImage(uri: String?, progressDrawable: CircularProgressDrawable) {
    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher_round)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}