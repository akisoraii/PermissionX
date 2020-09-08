package com.permissionx.yichendev

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

/**
 * 项目名称：PermissionX
 * 类 名 称：InvisibleFragment
 * 类 描 述：TODO
 * 创建时间：2020/9/8 14:08
 * 创 建 人：akisora
 */
//typealias关键字定义任意类型的别名
typealias permissionCallback = (Boolean,List<String>) -> Unit
class InvisibleFragment : Fragment(){
    //回调变量 作为回调通知方式
    private var callback : permissionCallback? = null
    fun requestNow(cb : permissionCallback,vararg permissions : String){
        callback = cb
        requestPermissions(permissions,1)
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 1){
            val deniedlist = ArrayList<String>()
            for ((index,result) in grantResults.withIndex()){
                if (result != PackageManager.PERMISSION_GRANTED){
                    deniedlist.add(permissions[index])
                }
            }
            val allGranted = deniedlist.isEmpty()
            callback?.let{it(allGranted,deniedlist) }
        }
    }
}