package com.ds.ximeng.kotlindemo.ui.home.fragment

import android.os.Bundle
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.ds.ximeng.kotlindemo.R
import com.ds.ximeng.kotlindemo.base.ui.BaseFragment



class HomeFragment : BaseFragment(){

    private lateinit var binding : com.ds.ximeng.kotlindemo.databinding.FragmentHomeBinding

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun init(savedInstanceState: Bundle?) {

    }


    override fun initBiding(container: ViewGroup?): ViewDataBinding {
        binding = bindingLayout(container)
        return binding
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

}