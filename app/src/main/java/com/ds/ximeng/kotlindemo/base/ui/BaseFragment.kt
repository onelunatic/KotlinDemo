package com.ds.ximeng.kotlindemo.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  initBiding(container).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(savedInstanceState)
    }

    protected fun <T : ViewDataBinding> bindingLayout(container: ViewGroup?) : T{
        return DataBindingUtil.inflate(layoutInflater,getLayoutId(),container,false)
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun init(savedInstanceState: Bundle?)

    protected  abstract fun initBiding(container: ViewGroup?) : ViewDataBinding

}