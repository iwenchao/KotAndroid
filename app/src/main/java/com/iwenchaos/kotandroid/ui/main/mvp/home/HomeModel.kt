package com.iwenchaos.kotandroid.ui.main.mvp.home

import com.iwenchaos.kotandroid.data.HomeBannerBean
import com.iwenchaos.kotandroid.net.ApiService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by chaos
 * on 2019/1/23. 15:51
 * 文件描述：
 */
class HomeModel @Inject constructor(private val apiService: ApiService) : HomeContract.Model {



    override fun getBannerData(): Observable<HomeBannerBean> = apiService.getHomeBanner()


    override fun onDestory() {

    }
}
