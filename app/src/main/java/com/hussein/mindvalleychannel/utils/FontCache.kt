package com.hussein.mindvalleychannel.utils

import android.content.Context
import android.graphics.Typeface

import java.util.HashMap

/** This object class for cache fonts in textviews **/
object FontCache {
    private val fontCache = HashMap<String, Typeface>()

    fun getTypeface(fontname: String, context: Context): Typeface? {
        var typeface = fontCache[fontname]

        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.assets, fontname)
            } catch (e: Exception) {
                return null
            }

            fontCache[fontname] = typeface
        }

        return typeface
    }
}
