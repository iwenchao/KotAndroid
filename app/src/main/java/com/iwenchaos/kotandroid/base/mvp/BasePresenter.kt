package com.iwenchaos.kotandroid.base.mvp

/**
 * Created by chaos
 * on 2019/1/22. 21:16
 * 文件描述：
 */

open class BasePresenter<V : IView, M : IModel> constructor(private var mModel: M? = null) : IPresenter<V> {
    var mView: V? = null

    override fun onAttach(view: V) {
        checkNotNull(view) {
            "${view::class.java.simpleName} cannot be null."
        }
        mView = view
    }

    override fun onDetach() {
    }

    override fun onDestroy() {
        mView = null
        mModel?.onDestory()
        mModel = null

    }

}