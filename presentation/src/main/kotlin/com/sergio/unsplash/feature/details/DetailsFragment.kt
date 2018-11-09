package com.sergio.unsplash.feature.details

import android.os.Bundle
import android.view.View
import com.sergio.unsplash.R
import com.sergio.unsplash.common.BaseFragment
import com.sergio.unsplash.common.exception.Failure
import com.sergio.unsplash.extensions.failure
import com.sergio.unsplash.extensions.load
import com.sergio.unsplash.extensions.observe
import com.sergio.unsplash.extensions.viewModel
import com.sergio.unsplash.navigation.Navigator.Companion.EXTRA_PHOTO_ID
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailsFragment  : BaseFragment() {

    private lateinit var detailsViewModel: DetailsViewModel

    private val photoId by lazy {
        activity?.intent?.extras?.getString(EXTRA_PHOTO_ID)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        initViewModel()
    }

    private fun initViewModel() {
        detailsViewModel = viewModel(viewModelFactory) {
            observe(photo, ::renderPhotoDetail)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (firstTimeCreated(savedInstanceState)) {
            photoId?.let { detailsViewModel.loadPhotoDetail(it) }
        }
    }

    override fun layoutId() = R.layout.fragment_detail

    private fun renderPhotoDetail(detail: DetailView?) {
        detail?.let {
            val url = it.mainPhotoUrl
            val thumb = it.thumb
            photoImageView.load(url, thumb, false) {
                activity?.supportStartPostponedEnterTransition()
            }
        }
    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {

        }
    }

}
