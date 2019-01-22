package com.iwenchaos.kotandroid.ui.splash.mvp

import android.content.Context
import android.content.SharedPreferences
import com.iwenchaos.kotandroid.R
import com.iwenchaos.kotandroid.base.mvp.BasePresenter
import com.iwenchaos.kotandroid.base.mvp.IModel
import io.reactivex.disposables.CompositeDisposable
import java.util.*
import javax.inject.Inject

/**
 * Created by chaos
 * on 2019/1/22. 21:30
 * 文件描述：
 */
class SplashPresenter @Inject constructor(
    private val splashView: SplashContract.View,
    private val disposable: CompositeDisposable
) : BasePresenter<SplashContract.View, IModel>() {

    @Inject
    lateinit var mContext: Context

    @Inject
    lateinit var mPreferences: SharedPreferences

    private val mImageList = listOf(
        R.mipmap.splash_image01,
        R.mipmap.splash_image02,
        R.mipmap.splash_image03,
        R.mipmap.splash_image04,
        R.mipmap.splash_image05
    )

    override fun onAttach(view: SplashContract.View) {
        super.onAttach(view)
        mView = splashView
        registerEvents()
    }

    private fun registerEvents() {
        setTextAnimation()
        setTimerParams()
        mView?.showBackgroundImage(mImageList[Random().nextInt(mImageList.size)])
    }

    /**
     * 给textview控件添加动画
     */
    private fun setTextAnimation() {

    }

    private fun setTimerParams() {

    }


    override fun onDestroy() {
        super.onDestroy()

    }
}