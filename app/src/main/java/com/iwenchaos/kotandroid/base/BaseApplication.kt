package com.iwenchaos.kotandroid.base

import android.app.Activity
import com.iwenchaos.kotandroid.common.ActivityLifecycleCallbacksImpl
import com.iwenchaos.kotandroid.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

/**
 * Created by chaos
 * on 2019/1/14. 14:42
 * 文件描述：
 */
class BaseApplication : DaggerApplication() {

    @Inject
    lateinit var mActivityLifecycleCallbacks: ActivityLifecycleCallbacksImpl
    @Inject
    lateinit var mActivityList: MutableList<Activity?>


    //伴随对象
    companion object {
        //延迟初始化，将setter设置私有，不予许被赋值
        lateinit var INSTANCE: BaseApplication
            private set
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()

        init()
    }


    private fun init() {
        INSTANCE = this
        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks)
    }


    fun quitApp() {
        for (activity in mActivityList) {
            activity?.finish()
        }
    }

}