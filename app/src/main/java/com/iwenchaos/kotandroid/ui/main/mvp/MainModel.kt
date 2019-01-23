package com.iwenchaos.kotandroid.ui.main.mvp

import com.iwenchaos.kotandroid.net.ApiService
import javax.inject.Inject

/**
 * Created by chaos
 * on 2019/1/23. 13:53
 * 文件描述：
 */
class MainModel @Inject constructor(private val apiService: ApiService) :MainContract.Model {


    override fun onDestory() {

    }
}