package com.hussein.mindvalleychannel.utils

import android.app.Activity
import android.graphics.Point

/** This object class contains all constant values **/
object Constant {
    const val BASE_URL="https://pastebin.com/"
    const val API_EXTENSION_URL="raw/"
    const val NEW_EPISODES_URL="z5AExTtw"
    const val CHANNELS_URL="Xt12uVhM"
    const val CATEGORIES_URL="A0CgArX3"

    const val NUM_OF_BANNERS=6
    fun screenDimensions(activity: Activity): Point? {
        return try {
            val size = Point()
            val display = activity.windowManager.defaultDisplay
            display.getSize(size)
            size
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
    fun getViewHolderITemSize(activity: Activity): Int {
        return try {
            (screenDimensions(activity)!!.x -140)/NUM_OF_BANNERS //140 here is padding and margin values in home item adpater recyclerivew
        } catch (e: Exception) {
            e.printStackTrace()
            200
        }
    }


}