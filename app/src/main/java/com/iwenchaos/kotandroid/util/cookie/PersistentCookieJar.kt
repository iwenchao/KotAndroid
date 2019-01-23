package com.iwenchaos.kotandroid.util.cookie

import okhttp3.Cookie
import okhttp3.HttpUrl

/**
 * Created by chaos
 * on 2019/1/23. 14:03
 * 文件描述：
 */
class PersistentCookieJar : ClearableCookieJar {
    override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>) {

    }

    override fun loadForRequest(url: HttpUrl): MutableList<Cookie> {
        //TODO 待实现细节
        return mutableListOf()
    }


    override fun clearSession() {

    }

    override fun clear() {
    }
}