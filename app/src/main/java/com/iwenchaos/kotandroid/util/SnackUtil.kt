package com.iwenchaos.kotandroid.util

import android.content.Context
import android.widget.Toast

/**
 * Created by chaos
 * on 2019/1/23. 15:19
 * 文件描述：
 */
object SnackUtil {


    fun showNormalToast(context: Context?,text:String){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show()
    }
}