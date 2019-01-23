package com.iwenchaos.kotandroid.base

import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import com.iwenchaos.kotandroid.base.mvp.IView
import dagger.android.support.DaggerFragment

/**
 * Created by chaos
 * on 2019/1/23. 15:56
 * 文件描述：
 */
abstract class BaseFragment : DaggerFragment(), IView {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initialize()
    }

    @LayoutRes
    abstract fun getLayoutResId(): Int

    abstract fun initialize()

    open fun initView() {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun handleMessage(message: Message) {

    }


    override fun getStringForResource(strId: Int): String = getString(strId)

}