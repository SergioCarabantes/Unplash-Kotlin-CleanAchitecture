package com.sergio.unsplash.feature.details

import android.os.Bundle
import com.sergio.unsplash.common.BaseActivity
import com.sergio.unsplash.common.BaseFragment

class DetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postponeEnterTransition()
    }

    override fun fragment(): BaseFragment = DetailsFragment()
}
