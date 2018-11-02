package com.sergio.unsplash.common

import androidx.appcompat.app.AppCompatActivity
import com.sergio.unsplash.R

abstract class BaseActivity : AppCompatActivity() {

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(
                R.id.fragment_container) as BaseFragment).onBackPressed()
        super.onBackPressed()
    }
}
