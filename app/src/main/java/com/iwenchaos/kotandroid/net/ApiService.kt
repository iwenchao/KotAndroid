package com.iwenchaos.kotandroid.net

import com.iwenchaos.kotandroid.data.HomeBannerBean
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by chaos
 * on 2019/1/23. 13:54
 * 文件描述：
 */
interface ApiService {


    @GET("banner/json")
    fun getHomeBanner(): Observable<HomeBannerBean>


}