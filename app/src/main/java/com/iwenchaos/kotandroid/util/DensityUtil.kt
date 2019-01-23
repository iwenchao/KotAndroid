package com.iwenchaos.kotandroid.util

import android.content.Context
import android.content.res.Resources

/**
 * Created by chaos
 * on 2019/1/23. 10:40
 * 文件描述：
 */
object DensityUtil {

    @JvmStatic
    fun getScreenWidth(): Int {
        return Resources.getSystem().displayMetrics.widthPixels
    }

    @JvmStatic
    fun getScreenHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }

    fun getStatusBarHeight(context: Context): Int {
        val identifier = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        var height = 0
        if (identifier > 0) {
            height = context.resources.getDimensionPixelSize(identifier)
        }
        return height
    }

    @JvmStatic
    fun dip2px(dpValue: Int): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }


}