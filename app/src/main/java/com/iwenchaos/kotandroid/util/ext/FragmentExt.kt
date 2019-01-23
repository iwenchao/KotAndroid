package com.iwenchaos.kotandroid.util.ext

import android.util.TypedValue
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.iwenchaos.kotandroid.R

/**
 * Created by chaos
 * on 2019/1/23. 16:28
 * 文件描述：
 */
fun Fragment.setupSwipeLayoutColor(swipeRefreshLayout: SwipeRefreshLayout) {
    val ta = context?.obtainStyledAttributes(
        TypedValue().data,
        intArrayOf(R.attr.colorPrimaryLight, R.attr.colorPrimary, R.attr.colorPrimaryDark)
    )
    val lightColor = ta?.getColor(0, ContextCompat.getColor(context!!, R.color.colorPrimaryLight))
    val primaryColor = ta?.getColor(1, ContextCompat.getColor(context!!, R.color.colorPrimary))
    val primaryDarkColor = ta?.getColor(2, ContextCompat.getColor(context!!, R.color.colorPrimaryDark))
    swipeRefreshLayout.setColorSchemeColors(lightColor!!, primaryColor!!, primaryDarkColor!!)
    ta.recycle()
}