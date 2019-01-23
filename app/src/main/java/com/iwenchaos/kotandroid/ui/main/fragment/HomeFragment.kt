package com.iwenchaos.kotandroid.ui.main.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.iwenchaos.kotandroid.R
import com.iwenchaos.kotandroid.base.BaseInjectFragment
import com.iwenchaos.kotandroid.common.RecyclerScrollListener
import com.iwenchaos.kotandroid.ui.main.mvp.home.HomeContract
import com.iwenchaos.kotandroid.ui.main.mvp.home.HomePresenter
import com.iwenchaos.kotandroid.util.ext.setupSwipeLayoutColor
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

/**
 * Created by chaos
 * on 2019/1/23. 15:56
 * 文件描述：
 */
class HomeFragment @Inject constructor() :BaseInjectFragment<HomePresenter>(),HomeContract.View,
    SwipeRefreshLayout.OnRefreshListener, RecyclerScrollListener.OnLoadMoreListener {



    private lateinit var mRecyclerScroller: RecyclerScrollListener


    override fun getLayoutResId(): Int = R.layout.fragment_home

    override fun initialize() {
        setupSwipeLayout()
        setupRecyclerView()
        mPresenter.onAttach(this)

    }


    private fun setupSwipeLayout(){
        setupSwipeLayoutColor(swipeLayout)
        swipeLayout.setOnRefreshListener(this)
    }

    private fun setupRecyclerView(){
        val layoutManager = LinearLayoutManager(context)
        mRecyclerScroller = RecyclerScrollListener(layoutManager)
        mRecyclerScroller.setOnLoadMoreListener(this)
        homeRecycler.run {
            this.layoutManager = layoutManager
            addOnScrollListener(mRecyclerScroller)

        }

    }



    override fun onRefresh() {

    }

    override fun onLoadMore() {

    }
}