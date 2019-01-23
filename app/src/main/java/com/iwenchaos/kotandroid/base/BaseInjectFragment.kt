package com.iwenchaos.kotandroid.base

import com.iwenchaos.kotandroid.base.mvp.IPresenter
import javax.inject.Inject

/**
 * Created by chaos
 * on 2019/1/23. 16:02
 * 文件描述：
 */
abstract class BaseInjectFragment<P : IPresenter<*>> : BaseFragment() {


    @Inject
    lateinit var mPresenter: P
}