package com.iwenchaos.kotandroid.util

import android.graphics.Typeface
import android.widget.TextView

/**
 * Created by chaos
 * on 2019/1/23. 10:34
 * 文件描述：
 */
object CommonUtil {

    fun setAssetsTextFont(textView: TextView?, languageType: Int?) {
        val assetFont = "font/Pacifico-Regula.ttf"
        try {
            textView?.typeface = Typeface.createFromAsset(textView?.context?.assets, assetFont)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}