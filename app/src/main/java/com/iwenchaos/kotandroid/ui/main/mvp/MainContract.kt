package com.iwenchaos.kotandroid.ui.main.mvp

import android.content.Intent
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.iwenchaos.kotandroid.base.mvp.IModel
import com.iwenchaos.kotandroid.base.mvp.IView

/**
 * Created by chaos
 * on 2019/1/23. 12:27
 * 文件描述：
 */
interface MainContract {


    interface View : IView {
        fun supportFragmentManager(): FragmentManager
        fun setPagerAdapter(adapter: FragmentStatePagerAdapter)
        fun startNewActivity(intent: Intent)
    }


    interface Model : IModel {

    }
}