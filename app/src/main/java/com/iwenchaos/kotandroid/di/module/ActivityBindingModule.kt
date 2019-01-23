package com.iwenchaos.kotandroid.di.module

import com.iwenchaos.kotandroid.di.scope.ActivityScope
import com.iwenchaos.kotandroid.ui.main.activity.MainActivity
import com.iwenchaos.kotandroid.ui.main.di.MainModule
import com.iwenchaos.kotandroid.ui.splash.SplashActivity
import com.iwenchaos.kotandroid.ui.splash.di.SplashModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by chaos
 * on 2019/1/22. 22:00
 * 文件描述：
 */
@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun contributeSplashActivity(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributeMainActivity(): MainActivity

}