package com.iwenchaos.kotandroid.util

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by chaos
 * on 2019/1/24. 13:42
 * 文件描述：
 */
object RxJavaHelper {


    /**
     * 将io线程转到ui线程
     */
    fun <T> compose(): ObservableTransformer<T, T> {
        return ObservableTransformer {
            it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }
}