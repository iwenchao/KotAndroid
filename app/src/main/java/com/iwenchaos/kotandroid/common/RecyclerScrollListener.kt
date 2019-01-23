package com.iwenchaos.kotandroid.common

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

/**
 * Created by chaos
 * on 2019/1/23. 16:36
 * 文件描述：
 */
class RecyclerScrollListener : RecyclerView.OnScrollListener {

    private var mLayoutManager: RecyclerView.LayoutManager? = null
    private var mOnLoadMoreListener: OnLoadMoreListener? = null


    constructor(layoutManager: LinearLayoutManager) {
        this.mLayoutManager = layoutManager
    }

    constructor(layoutManager: GridLayoutManager) {
        this.mLayoutManager = layoutManager
    }

    constructor(layoutManager: StaggeredGridLayoutManager) {
        this.mLayoutManager = layoutManager
    }


    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

    }


    fun  setOnLoadMoreListener(listener: OnLoadMoreListener){
        mOnLoadMoreListener = listener
    }

    interface OnLoadMoreListener {
        fun onLoadMore()
    }

}