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
        AndroidSupportInjectionModule::class,//配置绑定以确保{@code dagger.android}和{@code * dagger.android.support}框架类的可用性。, 此模块应安装在将使用这些类型的root-most *组件中。
        AppModule::class,
        CommonModule::class,
        ActivityBindingModule::class

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