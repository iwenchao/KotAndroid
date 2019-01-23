package com.iwenchaos.kotandroid.util.cookie

import okhttp3.CookieJar

/**
 * Created by chaos
 * on 2019/1/23. 14:07
 * 文件描述：
 */
interface ClearableCookieJar : CookieJar {

    fun clearSession()

    fun clear()
}