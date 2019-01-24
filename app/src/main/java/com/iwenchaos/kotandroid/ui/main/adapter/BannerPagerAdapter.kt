package com.iwenchaos.kotandroid.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.iwenchaos.kotandroid.R
import com.iwenchaos.kotandroid.common.glide.GlideApp
import com.iwenchaos.kotandroid.common.inter.OnItemClickListener
import com.iwenchaos.kotandroid.data.HomeBannerData
import com.iwenchaos.kotandroid.util.DensityUtil

/**
 * Created by chaos
 * on 2019/1/24. 13:04
 * 文件描述：
 */
class BannerPagerAdapter(private val context: Context, private val bannerList: List<HomeBannerData>) : PagerAdapter() {

    private var mImageHeight: Int? = 0
    private var mImageWidth: Int? = 0
    private var mItemClickListener: OnItemClickListener<HomeBannerData>? = null

    private val mInflator: LayoutInflater by lazy {
        LayoutInflater.from(context)
    }

    companion object {
        const val SIZE_MULTIPLE = 1000
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = mInflator.inflate(R.layout.layout_home_banner, null)
        val imgIv = view.findViewById<ImageView>(R.id.imageView)
        val transformation = MultiTransformation(CenterCrop(), RoundedCorners(DensityUtil.dip2px(5)))

        val bannerData = bannerList[position % bannerList.size]
        GlideApp.with(context)
            .load(bannerData.imagePath)
            .placeholder(R.mipmap.placeholder)
            .centerCrop()
            .transition(DrawableTransitionOptions.withCrossFade())
            .apply(RequestOptions.bitmapTransform(transformation))
            .into(imgIv)
        container.addView(view)
        view.layoutParams.height = mImageHeight!!
        view.setOnClickListener { mItemClickListener?.onItemClick(bannerData, position % bannerList.size) }
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return bannerList.size * SIZE_MULTIPLE
    }

    fun setImageSize(imageWidth: Int, imageHeight: Int) {
        mImageHeight = imageHeight
        mImageWidth = imageWidth
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: OnItemClickListener<HomeBannerData>) {
        mItemClickListener = listener
    }
}