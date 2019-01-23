package com.iwenchaos.kotandroid.net

import android.content.Context
import com.iwenchaos.kotandroid.util.cookie.PersistentCookieJar

/**
 * Created by chaos
 * on 2019/1/23. 14:31
 * 文件描述：
 */
class CookieManager constructor(context: Context) {

    //TODO 待实现cookie细节
    private val cookieJar: PersistentCookieJar = PersistentCookieJar()

    fun getCookieJar(): PersistentCookieJar {
        return cookieJar
    }


    fun clearCookieInfo() {
        cookieJar.clear()
    }

    companion object {
        private var INSTANCE: CookieManager? = null
        fun getInstance(context: Context): CookieManager {
            return INSTANCE ?: CookieManager(context).apply {
                INSTANCE = this
            }
        }
    }

}