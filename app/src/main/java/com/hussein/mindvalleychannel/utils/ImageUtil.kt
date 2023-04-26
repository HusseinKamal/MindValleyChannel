package com.hussein.mindvalleychannel.utils

import android.text.TextUtils
import android.widget.ImageView
import com.hussein.mindvalleychannel.R
import com.hussein.mindvalleychannel.views.RoundCornersTransformation
import com.squareup.picasso.Picasso

/** This object class for dealing with loading images **/
object ImageUtil {
    //I used PNG because SVG can't be downloaded from Figma Website
    fun bindUrlImage(view: ImageView, imageUrl: String?, width:Int, height:Int, cornet:Int, margin:Int) {
        if(!TextUtils.isEmpty(imageUrl)) {
            Picasso.get()
                .load(imageUrl)
                .resize(width, height)
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_placeholder)
                .transform(RoundCornersTransformation(cornet, margin, true, true))
                .into(view)
        }
        else
        {
            view.setImageResource(R.drawable.ic_placeholder)
        }
    }

    fun bindUrlImage(view: ImageView, imageUrl: String?) {
        if(!TextUtils.isEmpty(imageUrl)) {
            Picasso.get()
                .load(imageUrl)
                .placeholder(R.color.black_bg)
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_placeholder)
                .into(view)
        }
        else
        {
            view.setImageResource(R.drawable.ic_placeholder)
        }
    }
}