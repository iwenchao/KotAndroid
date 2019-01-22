package com.iwenchaos.kotandroid.di.module

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.iwenchaos.kotandroid.util.PreferenceHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
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


    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Singleton
    @Provides
    fun provideSharedPreference(context: Context): SharedPreferences {
        return PreferenceHelper.defaultPrefs(context)
    }
}