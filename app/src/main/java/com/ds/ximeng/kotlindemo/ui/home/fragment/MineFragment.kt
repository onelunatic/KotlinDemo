package com.ds.ximeng.kotlindemo.ui.home.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding

import com.ds.ximeng.kotlindemo.R
import com.ds.ximeng.kotlindemo.base.ui.BaseFragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MineFragment : BaseFragment() {

    private lateinit var binding : com.ds.ximeng.kotlindemo.databinding.FragmentMineBinding

    override fun getLayoutId(): Int {
        return R.layout.fragment_mine
    }

    override fun init(savedInstanceState: Bundle?) {

    }

    override fun initBiding(container: ViewGroup?): ViewDataBinding {
        binding = bindingLayout(container)
        return binding
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MineFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }


}
