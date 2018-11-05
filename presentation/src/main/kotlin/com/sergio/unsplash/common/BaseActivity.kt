package com.sergio.unsplash.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sergio.unsplash.R
import com.sergio.unsplash.extensions.inTransaction

abstract class BaseActivity : AppCompatActivity() {

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(
                R.id.fragment_container) as BaseFragment).onBackPressed()
        super.onBackPressed()
    }

    fun addFragment(savedInstanceState: Bundle?, fragment: Fragment) =
        savedInstanceState ?: supportFragmentManager.inTransaction { add(
            R.id.fragment_container, fragment) }
}
