package com.hussein.mindvalleychannel.views

import android.content.Context
import android.util.AttributeSet
import com.hussein.mindvalleychannel.utils.FontCache

/** This Class for custom text view with Robot Regular **/
class CustomRobotoRegularTextView : androidx.appcompat.widget.AppCompatTextView {
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        applyCustomFont(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        applyCustomFont(context)
    }

    constructor(context: Context) : super(context) {
        applyCustomFont(context)
    }

    private fun applyCustomFont(context: Context) {
        val customFont = FontCache.getTypeface("fonts/Roboto-Regular.ttf", context)
        typeface = customFont
    }
}
