package com.iwenchaos.kotandroid.ui.main.mvp

import android.content.Context
import androidx.fragment.app.Fragment
import com.iwenchaos.kotandroid.base.mvp.BasePresenter
import com.iwenchaos.kotandroid.base.mvp.IModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by chaos
 * on 2019/1/23. 12:28
 * 文件描述：
 */
class MainPresenter @Inject constructor(
    private val view: MainContract.View,
    private val model: MainModel,//TODO 为什么这里不能使用接口MainContract.Model??
    private val disposable: CompositeDisposable
) : BasePresenter<MainContract.View, IModel>(model) {

    @Inject
    lateinit var mContext: Context


    private var mFragmentList= mutableListOf<Fragment>()


    override fun onAttach(view: MainContract.View) {
        super.onAttach(view)
        mView = this.view
        initEvent()
    }

    private fun  initEvent(){

    }

    /**
     * 添加tab的内容fragment
     */
    private fun setupFragments(){
        mFragmentList.clear()
//        mFragmentList.add()
    }


    /**
     * 查看收藏内容
     */
    fun checkCollectionState(){

    }

}