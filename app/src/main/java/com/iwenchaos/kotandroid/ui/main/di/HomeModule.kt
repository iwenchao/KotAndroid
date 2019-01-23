package com.iwenchaos.kotandroid.ui.main.di

import androidx.fragment.app.Fragment
import com.iwenchaos.kotandroid.ui.main.mvp.home.HomeContract
import dagger.Binds
import dagger.Module

/**
 * Created by chaos
 * on 2019/1/23. 15:53
 * 文件描述：
 */
@Module
abstract class HomeModule {

    @Binds
    abstract fun provideHomeView(homeFragment: Fragment): HomeContract.View
}