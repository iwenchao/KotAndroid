package com.iwenchaos.kotandroid.ui.main.mvp

import android.content.Context
import androidx.fragment.app.Fragment
import com.iwenchaos.kotandroid.base.mvp.BasePresenter
import com.iwenchaos.kotandroid.base.mvp.IModel
import com.iwenchaos.kotandroid.common.FragmentPagerAdapter
import com.iwenchaos.kotandroid.ui.main.fragment.HomeFragment
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
    @Inject
    lateinit var mHomeFragment: HomeFragment
    @Inject
    lateinit var mHomeFragment2: HomeFragment
    @Inject
    lateinit var mHomeFragment3: HomeFragment
    @Inject
    lateinit var mHomeFragment4: HomeFragment

    private var mFragmentList= mutableListOf<Fragment>()


    override fun onAttach(view: MainContract.View) {
        super.onAttach(view)
        mView = this.view
        initEvent()
    }

    private fun  initEvent(){
        setupFragments()
    }

    /**
     * 添加tab的内容fragment
     */
    private fun setupFragments(){
        mFragmentList.clear()
        mFragmentList.add(mHomeFragment)
        mFragmentList.add(mHomeFragment2)
        mFragmentList.add(mHomeFragment3)
        mFragmentList.add(mHomeFragment4)
        val pagerAdapter = FragmentPagerAdapter(mView?.supportFragmentManager(), mFragmentList)
        mView?.setPagerAdapter(pagerAdapter)
    }


    /**
     * 查看收藏内容
     */
    fun checkCollectionState(){

    }

}