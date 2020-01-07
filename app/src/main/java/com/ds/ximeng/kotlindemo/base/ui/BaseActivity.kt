package com.ds.ximeng.kotlindemo.base.ui

import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.qmuiteam.qmui.util.QMUIStatusBarHelper

abstract class BaseActivity : AppCompatActivity(){

    protected lateinit var mContext : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        mContext = this
        if(statusTranslucent()){
            QMUIStatusBarHelper.translucent(this)
            QMUIStatusBarHelper.setStatusBarLightMode(this)
        }
        initBinding(null)
        init(savedInstanceState)
    }

    protected fun statusTranslucent() : Boolean{
        return true
    }

    protected fun <V : ViewDataBinding> bindingLayout(parent: ViewGroup?) : V {
        return DataBindingUtil.setContentView(this,getLayoutId())
    }

    protected abstract fun getLayoutId(): Int
    protected abstract fun initBinding(parent : ViewGroup?)
    protected abstract fun init(savedInstanceState: Bundle?)

}