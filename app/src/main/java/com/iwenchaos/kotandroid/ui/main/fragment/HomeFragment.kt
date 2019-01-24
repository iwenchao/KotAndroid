package com.iwenchaos.kotandroid.ui.main.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.iwenchaos.kotandroid.R
import com.iwenchaos.kotandroid.base.BaseInjectFragment
import com.iwenchaos.kotandroid.common.RecyclerScrollListener
import com.iwenchaos.kotandroid.data.HomeBannerData
import com.iwenchaos.kotandroid.ui.main.adapter.HomeAdapter
import com.iwenchaos.kotandroid.ui.main.mvp.home.HomeContract
import com.iwenchaos.kotandroid.ui.main.mvp.home.HomePresenter
import com.iwenchaos.kotandroid.util.ext.setupSwipeLayoutColor
import com.iwenchaos.kotandroid.view.banner.BannerView
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

/**
 * Created by chaos
 * on 2019/1/23. 15:56
 * 文件描述：
 */
class HomeFragment @Inject constructor() : BaseInjectFragment<HomePresenter>(), HomeContract.View,
    SwipeRefreshLayout.OnRefreshListener, RecyclerScrollListener.OnLoadMoreListener {


    private var mBannerView: BannerView? = null
    private lateinit var mRecyclerScroller: RecyclerScrollListener


    override fun getLayoutResId(): Int = R.layout.fragment_home

    override fun initialize() {
        setupSwipeLayout()
        setupRecyclerView()
        mPresenter.onAttach(this)

    }


    private fun setupSwipeLayout() {
        setupSwipeLayoutColor(swipeLayout)
        swipeLayout.setOnRefreshListener(this)
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(context)
        mRecyclerScroller = RecyclerScrollListener(layoutManager)
        mRecyclerScroller.setOnLoadMoreListener(this)
        homeRecycler.run {
            this.layoutManager = layoutManager
            addOnScrollListener(mRecyclerScroller)

        }

    }

    override fun getAppContext(): Context {
        return context!!
    }

    override fun getBannerHeaderView(): View {
        val headerView = LayoutInflater.from(context).inflate(R.layout.item_banner_header, null)
        mBannerView = headerView.findViewById(R.id.bannerView)
        mBannerView?.setOnItemClickListener(mPresenter)
        return headerView
    }

    override fun setAdapter(adapter: HomeAdapter) {
        homeRecycler.adapter = adapter
    }

    override fun showContentPage() {

    }

    override fun showBannerData(dataList: List<HomeBannerData>?) {
        mBannerView?.setBannerData(dataList)

    }

    override fun showLoadingPage() {

    }


    override fun showErrorPage() {
        swipeLayout.isRefreshing = false
        //默认错误布局
    }

    override fun loadCompleted() {
        swipeLayout.isRefreshing = false
    }


    override fun onRefresh() {

    }

    override fun onLoadMore() {

    }
}