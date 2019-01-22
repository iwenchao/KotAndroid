package com.iwenchaos.kotandroid.base.mvp

/**
 * Created by chaos
 * on 2019/1/22. 21:15
 * 文件描述：
 */
interface IPresenter<V : IView> {

    fun onAttach(view: V)

    fun onDetach()

    fun onDestroy()

}