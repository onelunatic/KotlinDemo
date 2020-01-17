package com.ds.ximeng.kotlindemo.ui

import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.ds.ximeng.kotlindemo.R
import com.ds.ximeng.kotlindemo.base.ui.BaseActivity
import com.ds.ximeng.kotlindemo.entity.home.HomeBean
import com.ds.ximeng.kotlindemo.ui.home.fragment.HomeFragment
import com.ds.ximeng.kotlindemo.ui.message.fragment.MessageFragment
import com.ds.ximeng.kotlindemo.ui.mine.fragment.MineFragment
import com.qmuiteam.qmui.widget.QMUITabSegment

class MainActivity : BaseActivity() {

    private lateinit var binding : com.ds.ximeng.kotlindemo.databinding.ActivityMainBinding
    private val fragments = mutableListOf<Fragment>()

    override fun init(savedInstanceState: Bundle?) {
        initBottomBar()


    }

    override fun initBinding(parent: ViewGroup?) {
        binding = bindingLayout(parent)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    private fun initBottomBar() {
        val homeTab = QMUITabSegment.Tab(resources.getDrawable(R.drawable.ic_launcher_background),
            resources.getDrawable(R.drawable.ic_launcher_background),"",false)
        val messageTab = QMUITabSegment.Tab(resources.getDrawable(R.drawable.ic_launcher_background),
            resources.getDrawable(R.drawable.ic_launcher_background),"",false)
        val mineTab = QMUITabSegment.Tab(resources.getDrawable(R.drawable.ic_launcher_background),
            resources.getDrawable(R.drawable.ic_launcher_background),"",false)

        binding.qmuiTab.addTab(homeTab)
        binding.qmuiTab.addTab(messageTab)
        binding.qmuiTab.addTab(mineTab)

        fragments.add(HomeFragment.newInstance())
        fragments.add(MessageFragment.newInstance())
        fragments.add(MineFragment.newInstance())

        binding.qmuiTab.addOnTabSelectedListener(object : QMUITabSegment.OnTabSelectedListener {
            override fun onTabSelected(index: Int) {
                changeFragment(index)
            }
            override fun onTabUnselected(index: Int) {}
            override fun onTabReselected(index: Int) {}
            override fun onDoubleTap(index: Int) {}
        })
        binding.qmuiTab.selectTab(0,true,true)
    }

    private fun changeFragment(tabIndex: Int) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        val tag = tabIndex.toString()
        var fragment = fragmentManager.findFragmentByTag(tag)
        hideFragment(tag, transaction, fragmentManager.fragments)
        if (fragment != null) {
            transaction.show(fragment)
        } else {
            fragment = fragments[tabIndex]
            transaction.add(R.id.fl_container, fragment, tag)
        }
        if (!fragments.contains(fragment)) {
            fragments.add(fragment)
        }
        transaction.commitAllowingStateLoss()
    }

    private fun hideFragment(tag: String, transaction: FragmentTransaction,fragments : List<Fragment>) {
        for (mFragment in fragments) {
            if (tag != mFragment.tag) {
                transaction.hide(mFragment)
            }
        }
    }
}
