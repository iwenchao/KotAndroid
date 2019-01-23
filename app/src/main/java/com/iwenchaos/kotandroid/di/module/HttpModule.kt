package com.iwenchaos.kotandroid.di.module

import android.content.Context
import com.iwenchaos.kotandroid.common.Constants
import com.iwenchaos.kotandroid.net.ApiService
import com.iwenchaos.kotandroid.net.CookieManager
import com.iwenchaos.kotandroid.net.OkHttpClientFactory
import com.iwenchaos.kotandroid.util.cookie.PersistentCookieJar
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by chaos
 * on 2019/1/23. 13:58
 * 文件描述：
 */
@Module
class HttpModule {


    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().client(client)
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.HEADERS
        }
    }
    @Singleton
    @Provides
    fun provideCookieJar(context: Context): PersistentCookieJar {
        return CookieManager.getInstance(context).getCookieJar()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor, cookieJar: PersistentCookieJar): OkHttpClient {
        return OkHttpClientFactory.createUnsafeOkHttpClient(interceptor, cookieJar)
    }

}