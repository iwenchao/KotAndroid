package com.iwenchaos.kotandroid.common

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.IntDef
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.iwenchaos.kotandroid.R
import com.iwenchaos.kotandroid.util.CommonUtil
import com.iwenchaos.kotandroid.util.DensityUtil

/**
 * Created by chaos
 * on 2019/1/23. 17:23
 * 文件描述：
 */
class LoadingFooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        const val STATE_LOADING = 0
        const val STATE_NO_CONTENT = 1
        const val STATE_COMPLETED = 2
    }

    @Retention(AnnotationRetention.SOURCE)
    @IntDef(STATE_NO_CONTENT, STATE_LOADING, STATE_COMPLETED)
    annotation class LoadingState


    @BindView(R.id.progress)
    @JvmField
    var progressBar: ProgressBar? = null
    @BindView(R.id.loadingTv)
    @JvmField
    var loadingTv: TextView? = null


    init {
        ButterKnife.bind(this, itemView)
        CommonUtil.setProgressbarColor(progressBar)
        itemView.layoutParams.width = DensityUtil.getScreenWidth()
    }

    fun updateLoadingState(@LoadingState state: Int) {
        when (state) {
            STATE_NO_CONTENT -> {
                itemView.visibility = View.VISIBLE
                progressBar?.visibility = View.GONE
                loadingTv?.setText(R.string.text_no_data)
            }
            STATE_LOADING -> {
                itemView.visibility = View.VISIBLE
                progressBar?.visibility = View.VISIBLE
                loadingTv?.setText(R.string.text_loading)
            }
            STATE_COMPLETED -> {
                itemView.visibility = View.GONE
            }

        }
    }

}