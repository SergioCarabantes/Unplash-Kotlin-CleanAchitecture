package com.sergio.unsplash.home.ui

import android.os.Bundle
import com.sergio.unsplash.R
import com.sergio.unsplash.common.BaseActivity
import com.sergio.unsplash.extensions.inTransaction
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        setSupportActionBar(toolbar)
        addFragment()
    }

    private fun addFragment() {
        supportFragmentManager.inTransaction {
            add( R.id.fragment_container, HomeFragment()) }
    }
}
