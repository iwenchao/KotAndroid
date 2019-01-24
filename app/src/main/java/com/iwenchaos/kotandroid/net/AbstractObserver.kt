package com.iwenchaos.kotandroid.net

import android.content.Intent
import android.widget.Toast
import com.iwenchaos.kotandroid.R
import com.iwenchaos.kotandroid.base.BaseApplication
import com.iwenchaos.kotandroid.ui.main.activity.MainActivity
import com.iwenchaos.kotandroid.util.NetworkUtil
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

/**
 * Created by chaos
 * on 2019/1/24. 13:46
 * 文件描述：
 */
abstract class AbstractObserver<T : Any>(private val disposable: CompositeDisposable? = null) : Observer<T> {


    abstract fun onSuccess(bean: T)
    abstract fun onFail(error: ApiException)

    override fun onSubscribe(d: Disposable) {
        disposable?.add(d)
    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        val apiException = ApiException.parseException(e)
        if (apiException.errorCode == ApiException.ERROR_TOKEN_EXPIRED) {
            quitAndStartLogin(apiException.showMessage)
        }else{
            onFail(apiException)
        }
    }

    override fun onComplete() {

    }


    private fun quitAndStartLogin(showMessage: String) {
        BaseApplication.INSTANCE.quitApp()
        val context = BaseApplication.INSTANCE.applicationContext
        Toast.makeText(context, showMessage, Toast.LENGTH_LONG).show()
        CookieManager.getInstance(context).clearCookieInfo()
        context.startActivity(Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        })
    }

}

class ApiException(val errorCode: Int, message: String?, val showMessage: String) : Exception() {
    companion object {
        const val ERROR_UNKONWN = -1
        const val ERROR_UNKONWN_HOST = -2
        const val ERROR_CONNECT_TIMEOUT = -3
        const val ERROR_TOKEN_EXPIRED = -4
        fun parseException(error: Throwable): ApiException {
            if (error is ApiException) return error

            val context = BaseApplication.INSTANCE.applicationContext
            val showMessage: String
            val code: Int
            if (error is UnknownHostException || error is HttpException) {
                code = ERROR_UNKONWN_HOST
                showMessage = if (!NetworkUtil.isNetworkAvailable(context)) {
                    context.getString(R.string.text_network_not_available)
                } else {
                    context.getString(R.string.text_address_not_reachable)
                }
            } else if (error is ConnectException
                || error is TimeoutException
                || error is SocketException
                || error is SocketTimeoutException
            ) {
                code = ERROR_CONNECT_TIMEOUT
                showMessage = context.getString(R.string.text_network_timeout)
            } else {
                code = ERROR_UNKONWN
                showMessage = error.message ?: context.getString(R.string.text_unknown_error)
            }
            return ApiException(code, error.message, showMessage)
        }

    }
}