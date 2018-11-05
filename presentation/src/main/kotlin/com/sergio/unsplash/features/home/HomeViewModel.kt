package com.sergio.unsplash.features.home

import androidx.lifecycle.MutableLiveData
import com.sergio.unsplash.common.BaseViewModel
import com.sergio.unsplash.domain.model.Photo
import com.sergio.unsplash.domain.usecase.GetPhotosUseCase
import com.sergio.unsplash.domain.usecase.GetPhotosUseCase.GetPhotosOutput
import com.sergio.unsplash.domain.usecase.GetPhotosUseCase.Request
import timber.log.Timber
import javax.inject.Inject


class HomeViewModel @Inject constructor(private val getPhotosUseCase: GetPhotosUseCase): BaseViewModel() {

    var photos: MutableLiveData<List<HomeView>> = MutableLiveData()

    fun loadPhotos() = getPhotosUseCase.execute(Request(), GetPhotosOutputImpl())

    inner class GetPhotosOutputImpl: GetPhotosOutput {
        override fun onSuccess(photoList: List<Photo>) {
            photos.value = photoList.map { HomeView(it.url) }
        }

        override fun onUnknownError(throwable: Throwable) {
            Timber.i("loadPhotos onUnknownError: $throwable")
            //handleFailure(throwable)
        }

    }
}
