package com.sergio.unsplash.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sergio.unsplash.domain.model.Photo
import com.sergio.unsplash.domain.usecase.GetPhotosUseCase
import com.sergio.unsplash.domain.usecase.GetPhotosUseCase.*
import com.sergio.unsplash.home.ui.HomeView
import timber.log.Timber
import javax.inject.Inject


class HomeViewModel @Inject constructor(private val getPhotosUseCase: GetPhotosUseCase): ViewModel() {

    var photos: MutableLiveData<List<HomeView>> = MutableLiveData()

    fun loadPhotos() = getPhotosUseCase.execute(Request(), GetPhotosOutputImpl())

    inner class GetPhotosOutputImpl: GetPhotosOutput {
        override fun onSuccess(photoList: List<Photo>) {
            photos.value = photoList.map { HomeView(it.url) }
        }

        override fun onUnknownError(throwable: Throwable) {
            Timber.i("loadPhotos onUnknownError: $throwable")
        }

    }
}
