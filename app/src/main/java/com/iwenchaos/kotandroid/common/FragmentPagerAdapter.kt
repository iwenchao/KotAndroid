package com.iwenchaos.kotandroid.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * Created by chaos
 * on 2019/1/24. 14:34
 * 文件描述：
 */
class FragmentPagerAdapter(
    fm: FragmentManager?,
    private val fragmentList: MutableList<Fragment>,
    private val titleList: List<String>? = null
) : FragmentStatePagerAdapter(fm) {


    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence? = titleList?.get(position)
}