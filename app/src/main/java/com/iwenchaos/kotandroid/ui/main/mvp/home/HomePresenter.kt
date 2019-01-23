package com.iwenchaos.kotandroid.ui.main.mvp.home

import com.iwenchaos.kotandroid.base.mvp.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by chaos
 * on 2019/1/23. 16:04
 * 文件描述：
 */
class HomePresenter @Inject constructor(private val model: HomeModel, private val disposable: CompositeDisposable) :
    BasePresenter<HomeContract.View, HomeContract.Model>(model) {




    override fun onAttach(view: HomeContract.View) {
        super.onAttach(view)


    }


}