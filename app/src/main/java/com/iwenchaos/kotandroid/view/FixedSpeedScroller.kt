package com.iwenchaos.kotandroid.view

import android.content.Context
import android.os.Build
import android.view.animation.Interpolator
import android.widget.Scroller

/**
 * Created by chaos
 * on 2019/1/24. 13:01
 * 文件描述：
 */
class FixedSpeedScroller(
    context: Context,
    interpolator: Interpolator? = null,
    flywheel: Boolean = context.applicationInfo.targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB
) :
    Scroller(context, interpolator, flywheel) {


    private var mDuration = 1500
    override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int) {
        super.startScroll(startX, startY, dx, dy, mDuration)
    }

    override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
        super.startScroll(startX, startY, dx, dy, mDuration)
    }

    fun setFixedDuration(duration: Int) {
        mDuration = duration
    }
}