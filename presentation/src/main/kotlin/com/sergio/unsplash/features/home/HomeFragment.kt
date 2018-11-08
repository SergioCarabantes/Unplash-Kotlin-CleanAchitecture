package com.sergio.unsplash.features.home

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sergio.unsplash.R
import com.sergio.unsplash.common.BaseFragment
import com.sergio.unsplash.common.exception.Failure
import com.sergio.unsplash.extensions.*
import com.sergio.unsplash.navigation.Navigator
import kotlinx.android.synthetic.main.empty.*
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    @Inject lateinit var navigator: Navigator
    @Inject lateinit var homeAdapter: HomeAdapter

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        initViewModel()
    }

    private fun initViewModel() {
        homeViewModel = viewModel(viewModelFactory) {
            observe(photos, ::renderPhotoList)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeRecyclerView()
        if (firstTimeCreated(savedInstanceState)) {
            loadPhotos()
        }
    }

    private fun initializeRecyclerView() {
        photosRecyclerView.layoutManager = LinearLayoutManager(context)
        photosRecyclerView.addOnScrollListener(recyclerViewOnScrollListener)
        photosRecyclerView.adapter = homeAdapter
        homeAdapter.clickListener = { navigator.showDetailScreen(activity!!, it.name) }
    }

    private val recyclerViewOnScrollListener: RecyclerView.OnScrollListener by lazy {
        photosRecyclerView.pagination { homeViewModel.loadPhotos(it) }
    }

    private fun loadPhotos() {
        emptyLayout.invisible()
        progressBar.visible()
        homeViewModel.loadPhotos()
    }

    override fun layoutId() = R.layout.fragment_home

    private fun renderPhotoList(list: List<HomeView>?) {
        progressBar.invisible()
        if (list!!.isNotEmpty()) {
            emptyLayout.invisible()
        } else {
            emptyLayout.visible()
        }
        homeAdapter.addContent(list)
    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.UnknowError -> emptyLayout.invisible()
        }
    }
}
