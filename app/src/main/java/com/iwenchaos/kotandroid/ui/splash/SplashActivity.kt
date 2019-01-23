package com.iwenchaos.kotandroid.ui.splash

import android.content.Intent
import android.widget.TextView
import com.iwenchaos.kotandroid.R
import com.iwenchaos.kotandroid.base.BaseActivity
import com.iwenchaos.kotandroid.common.inter.IAppCompatActivity
import com.iwenchaos.kotandroid.common.inter.TranslucentNavigation
import com.iwenchaos.kotandroid.ui.splash.mvp.SplashContract
import com.iwenchaos.kotandroid.ui.splash.mvp.SplashPresenter
import com.iwenchaos.kotandroid.util.ext.showImage
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * Created by chaos
 * on 2019/1/22. 21:12
 * 文件描述：倒计时+启动动画
 */
@TranslucentNavigation
class SplashActivity : BaseActivity<SplashPresenter>(), SplashContract.View, IAppCompatActivity {


    override fun getLayoutResId(): Int = R.layout.activity_splash


    override fun startInitialize() {
        mPresenter.onAttach(this)

    }

    override fun getTimerTextView(): TextView {
        return timerTv
    }

    override fun getPlayTextView(): TextView {
        return playTv
    }

    override fun getAndroidTextView(): TextView {
        return androidTv
    }

    override fun showTime(time: String) {
        timerTv.text = time
    }

    override fun showBackgroundImage(resId: Int) {
        splashIv.showImage(this, resId, -1)
    }

    override fun startNewActivity(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }

}