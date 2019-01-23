package com.iwenchaos.kotandroid.di.component

import android.app.Application
import com.iwenchaos.kotandroid.base.BaseApplication
import com.iwenchaos.kotandroid.di.module.ActivityBindingModule
import com.iwenchaos.kotandroid.di.module.AppModule
import com.iwenchaos.kotandroid.di.module.CommonModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by chaos
 * on 2019/1/14. 15:48
 * 文件描述：
 */

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,//用于绑定android扩展的组件 如v4等
        AppModule::class,
        CommonModule::class,
        ActivityBindingModule::class//用于绑定activity

    ]
)
interface ApplicationComponent : AndroidInjector<BaseApplication> {

    @dagger.Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}