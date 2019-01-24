package com.iwenchaos.kotandroid.ui.main.mvp.home

import com.iwenchaos.kotandroid.base.mvp.BasePresenter
import com.iwenchaos.kotandroid.common.inter.OnItemClickListener
import com.iwenchaos.kotandroid.data.HomeBannerBean
import com.iwenchaos.kotandroid.data.HomeBannerData
import com.iwenchaos.kotandroid.data.HomeItem
import com.iwenchaos.kotandroid.net.ApiException
import com.iwenchaos.kotandroid.net.ObserverImpl
import com.iwenchaos.kotandroid.ui.main.adapter.HomeAdapter
import com.iwenchaos.kotandroid.util.RxJavaHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by chaos
 * on 2019/1/23. 16:04
 * 文件描述：
 */
class HomePresenter @Inject constructor(private val model: HomeModel, private val disposable: CompositeDisposable) :
    BasePresenter<HomeContract.View, HomeContract.Model>(model), OnItemClickListener<HomeBannerData>,
    HomeAdapter.OnHomeItemActionListener {


    private var mPage: Int = 0

    private var homeItemList = mutableListOf<HomeItem>()
    private val mHomeAdapter: HomeAdapter by lazy {
        HomeAdapter(mView?.getAppContext(), homeItemList)
    }


    override fun onAttach(view: HomeContract.View) {
        super.onAttach(view)
        setupAdapter()
        refreshData()
    }

    private fun setupAdapter() {
//        EventBus.getDefault().register(this)

        mHomeAdapter.setHeaderBanner(mView?.getBannerHeaderView()!!)
        mHomeAdapter.setOnHomeItemActionListener(this)
        mView?.setAdapter(mHomeAdapter)
        mView?.showLoadingPage()
    }

    private fun refreshData() {
        mPage = 0
        requestBannerData()
    }


    private fun requestBannerData() {
        model.getBannerData()
            .compose(RxJavaHelper.compose())
            .subscribe(object : ObserverImpl<HomeBannerBean>(disposable) {
                override fun onSuccess(bean: HomeBannerBean) {
                    if (bean.errorCode == 0) {
                        mView?.showContentPage()
                        mView?.showBannerData(bean.data)
                    } else {
                        showErrors(bean.errorMsg!!)
                    }
                }

                override fun onFail(error: ApiException) {
                    showErrors(error.showMessage)
                }

            })
    }

    private fun showErrors(message: String) {
        mView?.showMessage(message)
        if (mPage == 0) {
            mView?.showErrorPage()
        } else {
            mPage--
            mView?.loadCompleted()
        }
    }


    override fun onItemClick(data: HomeBannerData, position: Int) {
    }

    override fun onStarClick(homeItem: HomeItem, position: Int) {

    }

    override fun onListClick(homeItem: HomeItem, position: Int) {
    }

    override fun onShareClick(homeItem: HomeItem, position: Int) {
    }
}