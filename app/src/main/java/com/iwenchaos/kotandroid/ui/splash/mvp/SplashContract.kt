package com.iwenchaos.kotandroid.ui.splash.mvp

import android.widget.TextView
import androidx.annotation.IdRes
import com.iwenchaos.kotandroid.base.mvp.IView

/**
 * Created by chaos
 * on 2019/1/22. 21:29
 * 文件描述：
 */
interface SplashContract {


    interface View : IView {

        fun getTimerTextView(): TextView
        fun getPlayTextView(): TextView
        fun getAndroidTextView(): TextView
        fun showTime(time:String)
        fun showBackgroundImage(@IdRes resId:Int)
        fun startNewActivity(clazz: Class<*>)
    }
}