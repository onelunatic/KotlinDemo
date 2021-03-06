package com.ds.ximeng.kotlindemo.ui.message.fragment

import android.os.Bundle
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding

import com.ds.ximeng.kotlindemo.R
import com.ds.ximeng.kotlindemo.base.ui.BaseFragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MessageFragment : BaseFragment() {

    private lateinit var binding : com.ds.ximeng.kotlindemo.databinding.FragmentMessageBinding

    override fun initBiding(container: ViewGroup?): ViewDataBinding {
        binding = bindingLayout(container)
        return binding
    }

    override fun init(savedInstanceState: Bundle?) {
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_message
    }

    private var param1: String? = null
    private var param2: String? = null

    companion object {
        @JvmStatic
        fun newInstance() =
            MessageFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
