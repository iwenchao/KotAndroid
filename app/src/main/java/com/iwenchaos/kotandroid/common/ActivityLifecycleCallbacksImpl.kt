package com.iwenchaos.kotandroid.common

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.iwenchaos.kotandroid.common.inter.IAppCompatActivity
import javax.inject.Inject

/**
 * Created by chaos
 * on 2019/1/22. 20:49
 * 文件描述：
 */
class ActivityLifecycleCallbacksImpl @Inject constructor() : Application.ActivityLifecycleCallbacks {

    @Inject
    lateinit var mActivityStack: MutableList<Activity?>


    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        if (!mActivityStack.contains(activity)) {
            mActivityStack.add(activity)
        }

        // 进入activity声明周期oncreate流程
        if (activity is IAppCompatActivity) {
            activity.beforeInflateView()
            activity.setContentView(activity.getLayoutResId())
            activity.startInitialize()
        }

    }

    override fun onActivityStarted(activity: Activity?) {
    }

    override fun onActivityResumed(activity: Activity?) {
    }

    override fun onActivityStopped(activity: Activity?) {
    }

    override fun onActivityPaused(activity: Activity?) {
    }

    override fun onActivityDestroyed(activity: Activity?) {
        if (mActivityStack.contains(activity)) {
            mActivityStack.remove(activity)
        }
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
    }
}