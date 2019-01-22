package com.iwenchaos.kotandroid.di.module

import android.content.Context
import com.iwenchaos.kotandroid.base.BaseApplication
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
    abstract fun provideContext(application: BaseApplication): Context


//    abstract fun provideActivityLifecycleCallbacks(callback: Activity)
}