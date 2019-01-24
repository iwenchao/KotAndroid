package com.iwenchaos.kotandroid.net

import com.iwenchaos.kotandroid.R
import com.iwenchaos.kotandroid.base.BaseApplication
import com.iwenchaos.kotandroid.data.BaseBean
import com.iwenchaos.kotandroid.data.GankBasedBean
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by chaos
 * on 2019/1/24. 13:45
 * 文件描述：
 */
abstract class ObserverImpl<T : BaseBean<*>>(private val disposable: CompositeDisposable? = null) :
    AbstractObserver<T>() {


    override fun onNext(t: T) {
        if (t.errorCode == -1001) {
            onError(
                ApiException(
                    ApiException.ERROR_TOKEN_EXPIRED,
                    t.errorMsg,
                    BaseApplication.INSTANCE.applicationContext.getString(R.string.text_token_expired)
                )
            )
        } else {
            onSuccess(t)
        }
    }

}

abstract class GankObserverImpl<T : GankBasedBean<*>>(private val disposable: CompositeDisposable? = null) :
    AbstractObserver<T>()