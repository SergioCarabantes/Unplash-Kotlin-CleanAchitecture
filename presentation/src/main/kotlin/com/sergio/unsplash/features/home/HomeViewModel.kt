package com.sergio.unsplash.features.home

import androidx.lifecycle.MutableLiveData
import com.sergio.unsplash.common.BaseViewModel
import com.sergio.unsplash.domain.model.Photo
import com.sergio.unsplash.domain.usecase.GetPhotosUseCase
import com.sergio.unsplash.domain.usecase.GetPhotosUseCase.GetPhotosOutput
import io.reactivex.disposables.Disposable
import timber.log.Timber
import javax.inject.Inject


class HomeViewModel @Inject constructor(private val getPhotosUseCase: GetPhotosUseCase): BaseViewModel() {

    var photos: MutableLiveData<List<HomeView>> = MutableLiveData()

    fun loadPhotos(page: Int = 1): Disposable {
        return getPhotosUseCase.execute(GetPhotosUseCase.GetPhotosRequest(page), GetPhotosOutputImpl())
    }

    inner class GetPhotosOutputImpl: GetPhotosOutput {
        override fun onSuccess(photoList: List<Photo>) {
            photos.value = photoList.map { HomeView(it.url, it.name) }
        }

        override fun onUnknownError(throwable: Throwable) {
            Timber.i("loadPhotos onUnknownError: $throwable")
            //handleFailure(throwable)
        }

    }
}
