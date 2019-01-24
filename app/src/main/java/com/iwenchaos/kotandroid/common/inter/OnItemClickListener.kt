package com.iwenchaos.kotandroid.common.inter

/**
 * Created by chaos
 * on 2019/1/24. 13:15
 * 文件描述：
 */
interface OnItemClickListener<T> {

    fun onItemClick(data: T, position: Int)
}