package com.permissionx.yichendev

import androidx.fragment.app.FragmentActivity

/**
 * 项目名称：PermissionX
 * 类 名 称：PermissionX
 * 类 描 述：TODO
 * 创建时间：2020/9/8 14:37
 * 创 建 人：akisora
 */
object PermissionX {
    private const val TAG = "InvisibleFragment"

    fun request(activity : FragmentActivity,vararg permissions :
    String,callback: permissionCallback){
        val fragmentManager = activity.supportFragmentManager
        val existFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if (existFragment !=  null){
            existFragment as InvisibleFragment
        }else{
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback,*permissions)
    }
}