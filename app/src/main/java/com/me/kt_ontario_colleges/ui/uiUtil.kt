package com.me.kt_ontario_colleges.ui

import android.content.Context
import android.net.Uri
import android.util.TypedValue
import android.widget.ImageView
import androidx.annotation.AttrRes
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.me.kt_ontario_colleges.R

val <T> T.exhaustive: T
    get() = this

fun getProgressDrawable(context: Context): CircularProgressDrawable {
    val color = context.themeColor(R.attr.colorSecondary)
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 30f
        setColorSchemeColors(color, color)
        start()
    }
}

private fun Context.themeColor(@AttrRes attrRes: Int): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute (attrRes, typedValue, true)
    return typedValue.data
}