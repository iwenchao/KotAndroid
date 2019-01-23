package com.iwenchaos.kotandroid.ui.splash.mvp

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.SharedPreferences
import android.view.animation.OvershootInterpolator
import com.iwenchaos.kotandroid.R
import com.iwenchaos.kotandroid.base.mvp.BasePresenter
import com.iwenchaos.kotandroid.base.mvp.IModel
import com.iwenchaos.kotandroid.common.Constants
import com.iwenchaos.kotandroid.util.CommonUtil
import com.iwenchaos.kotandroid.util.DensityUtil
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
        val languageType = mPreferences.getInt(Constants.LANGUAGE_TYPE, 0)//TODO 如何转化成[]访问方式？
        CommonUtil.setAssetsTextFont(mView?.getAndroidTextView(), languageType)
        CommonUtil.setAssetsTextFont(mView?.getPlayTextView(), languageType)
        val halfScreenWidth = DensityUtil.getScreenWidth() * 1.0f / 2
        val textPaint = mView?.getPlayTextView()?.paint
        val playTextWidth = textPaint?.measureText(mView?.getPlayTextView()?.text.toString()) ?: 0f
        val androidTextWidth = textPaint?.measureText(mView?.getAndroidTextView()?.text.toString()) ?: 0f
        val playDistance = halfScreenWidth + playTextWidth / 2
        val androidDistance = halfScreenWidth + androidTextWidth / 2

        val playTranslateX = ObjectAnimator.ofFloat(mView?.getPlayTextView(), "translationX", 0f, playDistance)
        val playScaleX = ObjectAnimator.ofFloat(mView?.getPlayTextView(), "scaleX", 0.5f, 1.0f)
        val playScaleY = ObjectAnimator.ofFloat(mView?.getPlayTextView(), "scaleY", 0.5f, 1.0f)

        val androidTranslationX =
            ObjectAnimator.ofFloat(mView?.getAndroidTextView(), "translationX", 0f, -androidDistance)
        val androidScaleX = ObjectAnimator.ofFloat(mView?.getAndroidTextView(), "scaleX", 0.5f, 1.0f)
        val androidScaleY = ObjectAnimator.ofFloat(mView?.getAndroidTextView(), "scaleY", 0.5f, 1.0f)

        val animatorSet = AnimatorSet()
        animatorSet.let {
            it.playTogether(playTranslateX, androidTranslationX, playScaleX, playScaleY, androidScaleX, androidScaleY)
            it.duration = 1200
            it.interpolator = OvershootInterpolator()
        }
        mView?.getAndroidTextView()?.postDelayed({ animatorSet.start() }, 500)

    }

    private fun setTimerParams() {

    }


    override fun onDestroy() {
        super.onDestroy()

    }
}



