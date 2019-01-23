package com.iwenchaos.kotandroid.common.glide

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.AppGlideModule
import java.io.InputStream

/**
 * Created by chaos
 * on 2019/1/22. 22:53
 * 文件描述：
 */
@GlideModule
class KotGlideModule : AppGlideModule() {
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setMemoryCache(LruResourceCache(10 * 1024 * 1024))
    }

    /**
     * 清单解析的开启
     * 这里不开启，避免添加相同的modules两次
     * @return
     */
    override fun isManifestParsingEnabled(): Boolean {
        return false
    }


    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.append(String::class.java, InputStream::class.java, GlideUrlLoader.Factory())
    }


}