package com.iwenchaos.kotandroid.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.chip.Chip
import com.iwenchaos.kotandroid.R
import com.iwenchaos.kotandroid.common.Constants
import com.iwenchaos.kotandroid.common.LoadingFooterViewHolder
import com.iwenchaos.kotandroid.data.HomeItem
import com.iwenchaos.kotandroid.view.CheckableImageView
import com.iwenchaos.kotandroid.view.CircleTextView
import com.iwenchaos.kotandroid.view.LabelView

/**
 * Created by chaos
 * on 2019/1/23. 17:08
 * 文件描述：
 */
class HomeAdapter(context: Context?, private val dataList: List<HomeItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mInflater = LayoutInflater.from(context)
    private var mLoadingState: Int = LoadingFooterViewHolder.STATE_LOADING
    private var mOnHomeItemActionListener: OnHomeItemActionListener? = null
    private lateinit var mHeaderView: View


    companion object {
        const val ITEM_HEADER_COUNT = 1
        const val ITEM_FOOTER_COUNT = 1
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Constants.ITEM_TYPE_HEADER -> HomeBannerViewHolder(mHeaderView)
            Constants.ITEM_TYPE_CONTENT -> HomeItemViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_home_news, parent, false)
            )
            Constants.ITEM_TYPE_FOOTER -> LoadingFooterViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_loading_footer, parent, false)
            )
            else -> null!!
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HomeItemViewHolder -> holder.bindItemDate(dataList[position - 1], position)
            is LoadingFooterViewHolder -> holder.updateLoadingState(mLoadingState)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size + ITEM_HEADER_COUNT + ITEM_FOOTER_COUNT;
    }


    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> return Constants.ITEM_TYPE_HEADER
            in 1..dataList.size -> Constants.ITEM_TYPE_CONTENT
            dataList.size + 1 -> Constants.ITEM_TYPE_FOOTER
            else -> return Constants.ITEM_TYPE_NONE
        }
    }

    fun setHeaderBanner(headerView: View) {
        mHeaderView = headerView
        notifyItemChanged(0)
    }


    fun setOnHomeItemActionListener(listener: OnHomeItemActionListener) {
        mOnHomeItemActionListener = listener
    }


    fun updateLoadingState(@LoadingFooterViewHolder.LoadingState state: Int) {
        this.mLoadingState = state
        notifyItemChanged(dataList.size + 1)
    }


    class HomeBannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class HomeItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.nameCircleTv)
        @JvmField
        var nameCircleTv: CircleTextView? = null

        @BindView(R.id.labelView)
        @JvmField
        var labelView: LabelView? = null

        @BindView(R.id.authorTv)
        @JvmField
        var authorTv: TextView? = null

        @BindView(R.id.timeTv)
        @JvmField
        var timeTv: TextView? = null

        @BindView(R.id.titleTv)
        @JvmField
        var titleTv: TextView? = null

        @BindView(R.id.superChapterChip)
        @JvmField
        var superChapterChip: Chip? = null

        @BindView(R.id.chapterChip)
        @JvmField
        var chapterChip: Chip? = null

        @BindView(R.id.starIv)
        @JvmField
        var starIv: CheckableImageView? = null

        @BindView(R.id.starRl)
        @JvmField
        var starRl: RelativeLayout? = null

        @BindView(R.id.shareIv)
        @JvmField
        var shareIv: ImageView? = null


        init {
            ButterKnife.bind(this, itemView)
        }

        fun bindItemDate(homeItem: HomeItem, position: Int) {

            shareIv?.setOnClickListener {
                mOnHomeItemActionListener?.onShareClick(homeItem, position)
            }

            starRl?.setOnClickListener {
                mOnHomeItemActionListener?.onStarClick(homeItem, position)
            }

            itemView.setOnClickListener {
                mOnHomeItemActionListener?.onListClick(homeItem, position)
            }
        }
    }


    interface OnHomeItemActionListener {
        fun onStarClick(homeItem: HomeItem, position: Int)
        fun onListClick(homeItem: HomeItem, position: Int)
        fun onShareClick(homeItem: HomeItem, position: Int)
    }

}