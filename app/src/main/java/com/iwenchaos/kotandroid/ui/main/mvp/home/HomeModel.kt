package com.iwenchaos.kotandroid.ui.main.mvp.home

import com.iwenchaos.kotandroid.net.ApiService
import javax.inject.Inject

/**
 * Created by chaos
 * on 2019/1/23. 15:51
 * 文件描述：
 */
class HomeModel @Inject constructor(private val apiService: ApiService) : HomeContract.Model {


    override fun onDestory() {

    }
}