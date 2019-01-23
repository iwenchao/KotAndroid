package com.iwenchaos.kotandroid.ui.main.activity

import com.iwenchaos.kotandroid.R
import com.iwenchaos.kotandroid.base.BaseActivity
import com.iwenchaos.kotandroid.ui.main.mvp.MainContract
import com.iwenchaos.kotandroid.ui.main.mvp.MainPresenter

/**
 * Created by chaos
 * on 2019/1/14. 15:35
 * 文件描述：
 */
class MainActivity : BaseActivity<MainPresenter>(), MainContract.View {


    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun startInitialize() {
    }


}