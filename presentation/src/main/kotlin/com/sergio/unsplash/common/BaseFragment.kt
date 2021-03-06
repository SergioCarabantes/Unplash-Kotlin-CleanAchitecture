package com.sergio.unsplash.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sergio.unsplash.UnsplashApplication
import com.sergio.unsplash.di.components.ApplicationComponent
import javax.inject.Inject

abstract class BaseFragment : Fragment() {

    abstract fun layoutId(): Int

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (activity?.application as UnsplashApplication).applicationComponent
    }

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(layoutId(), container, false)

    internal fun firstTimeCreated(savedInstanceState: Bundle?) = savedInstanceState == null

    open fun onBackPressed() {}

}
