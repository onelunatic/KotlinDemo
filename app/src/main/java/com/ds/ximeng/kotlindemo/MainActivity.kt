package com.ds.ximeng.kotlindemo

import android.os.Bundle
import android.view.ViewGroup
import com.ds.ximeng.kotlindemo.base.ui.BaseActivity

class MainActivity : BaseActivity() {

    private lateinit var binding : com.ds.ximeng.kotlindemo.databinding.ActivityMainBinding

    override fun init(savedInstanceState: Bundle?) {
        binding.tv.text = getString(R.string.tttt)
    }

    override fun initBinding(parent: ViewGroup?) {
        binding = bindingLayout(parent)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

}
