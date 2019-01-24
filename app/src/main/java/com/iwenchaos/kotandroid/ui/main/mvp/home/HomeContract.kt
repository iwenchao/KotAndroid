package com.iwenchaos.kotandroid.ui.main.mvp.home

import android.content.Context
import com.iwenchaos.kotandroid.base.mvp.IModel
import com.iwenchaos.kotandroid.base.mvp.IView
import com.iwenchaos.kotandroid.data.HomeBannerBean
import com.iwenchaos.kotandroid.data.HomeBannerData
import com.iwenchaos.kotandroid.ui.main.adapter.HomeAdapter
import io.reactivex.Observable

/**
 * Created by chaos
 * on 2019/1/23. 15:50
 * 文件描述：
 */
interface HomeContract {


    interface View : IView {

        fun getAppContext(): Context
        fun getBannerHeaderView(): android.view.View

        fun setAdapter(adapter: HomeAdapter)

        fun showContentPage()
        fun showBannerData(dataList:List<HomeBannerData>?)

        fun showLoadingPage()
        fun showErrorPage()
        fun loadCompleted()

    }

    interface Model : IModel {
        fun getBannerData(): Observable<HomeBannerBean>
    }
}