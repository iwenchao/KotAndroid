package com.iwenchaos.kotandroid.di.module

import android.app.Application
import android.content.Context
import com.iwenchaos.kotandroid.common.ActivityLifecycleCallbacksImpl
import dagger.Binds
import dagger.Module

/**
 * Created by chaos
 * on 2019/1/14. 15:53
 * 文件描述：
 */

@Module
abstract class AppModule {

    @Binds
    abstract fun provideContext(application: Application): Context


    @Binds
    abstract fun provideActivityLifecycleCallbacks(callback: ActivityLifecycleCallbacksImpl): Application.ActivityLifecycleCallbacks



}