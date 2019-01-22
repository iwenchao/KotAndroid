package com.iwenchaos.kotandroid.base

import com.iwenchaos.kotandroid.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by chaos
 * on 2019/1/14. 14:42
 * 文件描述：
 */
class BaseApplication : DaggerApplication() {


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return DaggerApplicationComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}