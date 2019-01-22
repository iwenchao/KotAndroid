package com.iwenchaos.kotandroid.base

import android.os.Message
import com.iwenchaos.kotandroid.base.mvp.IPresenter
import com.iwenchaos.kotandroid.base.mvp.IView
import com.iwenchaos.kotandroid.common.inter.IAppCompatActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by chaos
 * on 2019/1/22. 21:12
 * 文件描述：
 */
abstract class BaseActivity<P : IPresenter<*>> : DaggerAppCompatActivity(), IAppCompatActivity, IView {

    @Inject
    lateinit var mPresenter: P


    override fun beforeInflateView() {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {
    }

    override fun showMessage(msg: String?) {
    }

    override fun handleMessage(msg: Message) {
    }

    override fun getStringForResource(strId: Int): String = getString(strId)
}