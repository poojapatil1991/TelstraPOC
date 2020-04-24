package com.example.myapplication.telstraPOC.utils

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.myapplication.R
/*
This class is used to download image from server.
Glide library is used to download image from server.
 */

class GlideImageDownloader {
    fun downloadImage(c: Context, url: String?, img: ImageView) {
        // Progress bar to show till image gets download
        val circularProgressDrawable = CircularProgressDrawable(CountryFeatureApplication.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 20f
        circularProgressDrawable.start()

        if (url != null && url.length > 0 &&  !url.equals("") ) {
            Glide.with(c).load(url).error(R.mipmap.ic_launcher).placeholder(circularProgressDrawable).into(img)
        } else {
            Glide.with(c).load(R.mipmap.ic_launcher).placeholder(circularProgressDrawable).into(img)
        }
    }
}