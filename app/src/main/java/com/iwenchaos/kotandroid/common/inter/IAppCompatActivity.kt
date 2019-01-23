package com.iwenchaos.kotandroid.common.inter

import androidx.annotation.LayoutRes

/**
 * Created by chaos
 * on 2019/1/22. 21:23
 * 文件描述：
 */
interface IAppCompatActivity {

    /**
     * 在inflate之前的操作
     */
    fun beforeInflateView()

    /**
     * 获取布局layout id
     */
    @LayoutRes
    fun getLayoutResId(): Int


    /**
     * 开始初始化
     */
    fun initialize()


}