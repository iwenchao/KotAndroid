package com.iwenchaos.kotandroid.base.mvp

import android.os.Message

/**
 * Created by chaos
 * on 2019/1/22. 21:13
 * 文件描述：
 */
interface IView {

    fun showLoading()

    fun hideLoading()

    fun showMessage(msg: String?)

    fun handleMessage(msg: Message)

    fun getStringForResource(strId: Int): String

}