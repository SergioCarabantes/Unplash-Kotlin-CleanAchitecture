package com.sergio.unsplash.features.home

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.sergio.unsplash.R
import com.sergio.unsplash.common.BaseFragment
import com.sergio.unsplash.common.exception.Failure
import com.sergio.unsplash.extensions.*
import kotlinx.android.synthetic.main.empty.*
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    @Inject lateinit var homeAdapter: HomeAdapter

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        initViewModel()
    }

    private fun initViewModel() {
        homeViewModel = viewModel(viewModelFactory) {
            observe(photos, ::renderUserList)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeRecyclerView()
        loadPhotos()
    }

    private fun initializeRecyclerView() {
        photoList.layoutManager = LinearLayoutManager(context)
        photoList.adapter = homeAdapter
    }

    private fun loadPhotos() {
        emptyLayout.invisible()
        progressBar.visible()
        homeViewModel.loadPhotos()
    }

    override fun layoutId() = R.layout.fragment_home

    private fun renderUserList(userList: List<HomeView>?) {
        progressBar.invisible()
        if (userList!!.isNotEmpty()) {
            emptyLayout.invisible()
        } else {
            emptyLayout.visible()
        }
        homeAdapter.photoList = userList.orEmpty()
    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.UnknowError -> emptyLayout.invisible()
        }
    }
}
