package com.iwenchaos.kotandroid.ui.splash.di

import com.iwenchaos.kotandroid.di.scope.ActivityScope
import com.iwenchaos.kotandroid.ui.splash.SplashActivity
import com.iwenchaos.kotandroid.ui.splash.mvp.SplashContract
import dagger.Binds
import dagger.Module

/**
 * Created by chaos
 * on 2019/1/22. 22:02
 * 文件描述：
 */
@Module
abstract class SplashModule {

    @ActivityScope
    @Binds
    abstract fun provideSplashView(activity: SplashActivity): SplashContract.View
}