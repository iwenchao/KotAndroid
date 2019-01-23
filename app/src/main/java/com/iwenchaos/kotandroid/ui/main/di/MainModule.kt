package com.iwenchaos.kotandroid.ui.main.di

import com.iwenchaos.kotandroid.di.scope.ActivityScope
import com.iwenchaos.kotandroid.net.ApiService
import com.iwenchaos.kotandroid.ui.main.activity.MainActivity
import com.iwenchaos.kotandroid.ui.main.mvp.MainContract
import com.iwenchaos.kotandroid.ui.main.mvp.MainModel
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Created by chaos
 * on 2019/1/23. 12:33
 * 文件描述：
 */
@Module
abstract class MainModule {


    @ActivityScope
    @Binds
    abstract fun provideMainView(activity: MainActivity): MainContract.View

    @Module
    companion object {

        @ActivityScope
        @Provides
        fun provideMainModel(apiService: ApiService): MainContract.Model {
            return MainModel(apiService)
        }
    }

}