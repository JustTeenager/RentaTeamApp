package com.example.rentateamapp.presenter.core

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.rentateamapp.R
import javax.inject.Inject

class GlideManager @Inject constructor(private val context: Context) {

    fun loadAvatar(url: String?, view: ImageView) {
        Glide.with(context)
            .load(url)
            .error(R.drawable.ic_launcher_background)
            .into(view)
    }

}