package com.ds.ximeng.kotlindemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ds.ximeng.kotlindemo.R
import com.ds.ximeng.kotlindemo.ui.home.fragment.HomeFragment

class TextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)

        supportFragmentManager.beginTransaction().add(R.id.fl_container,HomeFragment.newInstance()).commitAllowingStateLoss()
    }
}
