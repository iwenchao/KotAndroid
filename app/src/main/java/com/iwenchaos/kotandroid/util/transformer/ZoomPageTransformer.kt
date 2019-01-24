package com.iwenchaos.kotandroid.util.transformer

import android.view.View
import androidx.viewpager.widget.ViewPager

/**
 * Created by chaos
 * on 2019/1/24. 12:52
 * 文件描述：
 */
class ZoomPageTransformer(private val viewPager: ViewPager) : ViewPager.PageTransformer {


    private var mOffset: Float = 0.toFloat()
    private var mTranslationX: Float = 0.toFloat()

    companion object {
        const val MAX_SCALE_FACTOR = 1.0f
        const val MIN_SCALE_FACTOR = .85f
    }


    override fun transformPage(page: View, position: Float) {
        if (mOffset == 0f) {
            val paddingLeft = viewPager.paddingLeft.toFloat();
            val paddingRight = viewPager.paddingRight.toFloat()
            val width = viewPager.width.toFloat()
            mOffset = paddingLeft / (width - paddingLeft - paddingRight)
        }
        val currentPos = position - mOffset
        page.apply {
            if (mTranslationX == 0f) {
                mTranslationX = (2.0f - MAX_SCALE_FACTOR - MIN_SCALE_FACTOR) * width / 2.0f
            }
            when {
                currentPos <= -1.0f -> {
                    translationX = mTranslationX
                    scaleX = MIN_SCALE_FACTOR
                    scaleY = MIN_SCALE_FACTOR
                }
                currentPos <= 1.0f -> {
                    val scale = (MAX_SCALE_FACTOR - MIN_SCALE_FACTOR) * Math.abs(1.0f - Math.abs(currentPos))
                    val tranX = -mTranslationX * currentPos
                    scaleX = MIN_SCALE_FACTOR + scale
                    scaleY = MIN_SCALE_FACTOR + scale
                }
                else -> {
                    translationX = -mTranslationX
                    scaleX = MIN_SCALE_FACTOR
                    scaleY = MIN_SCALE_FACTOR
                }
            }
        }


    }
}