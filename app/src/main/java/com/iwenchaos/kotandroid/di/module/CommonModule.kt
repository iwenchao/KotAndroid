package com.iwenchaos.kotandroid.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by chaos
 * on 2019/1/22. 21:02
 * 文件描述：
 */
@Module
class CommonModule {

    @Singleton
    @Provides
    fun provideActivityList(): List<Activity?> {
        return mutableListOf()
    }
}