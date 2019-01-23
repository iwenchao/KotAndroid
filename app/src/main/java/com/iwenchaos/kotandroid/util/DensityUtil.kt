package com.iwenchaos.kotandroid.util

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

}