package com.iwenchaos.kotandroid.util

import android.graphics.Typeface
import android.util.TypedValue
import android.widget.ProgressBar
import android.widget.TextView
import com.iwenchaos.kotandroid.R

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

    fun setProgressbarColor(progressBar: ProgressBar?) {
        val drawable = progressBar?.indeterminateDrawable?.mutate()
        val ta = progressBar?.context?.obtainStyledAttributes(TypedValue().data, intArrayOf(R.attr.colorProgress))
        val color = ta?.getColor(0, 0)
        ta?.recycle()
        drawable?.setColorFilter(color!!, android.graphics.PorterDuff.Mode.SRC_IN)
        progressBar?.progressDrawable = drawable
    }

}