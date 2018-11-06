package com.sergio.unsplash.features.home

import android.os.Bundle
import com.sergio.unsplash.R
import com.sergio.unsplash.common.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        addFragment(savedInstanceState, HomeFragment())
    }
}
