package com.sergio.unsplash.feature.details

import androidx.lifecycle.MutableLiveData
import com.sergio.unsplash.common.BaseViewModel
import com.sergio.unsplash.domain.model.Photo
import com.sergio.unsplash.domain.usecase.GetPhotoDetailUseCase
import io.reactivex.disposables.Disposable
import timber.log.Timber
import javax.inject.Inject


class DetailsViewModel @Inject constructor(private val getPhotoDetailUseCase: GetPhotoDetailUseCase): BaseViewModel() {

    val photo: MutableLiveData<DetailView> by lazy { MutableLiveData<DetailView>() }

    fun loadPhotoDetail(photoId: String): Disposable = getPhotoDetailUseCase.execute(
        GetPhotoDetailUseCase.Request(photoId), GetPhotosOutputImpl()
    )

    inner class GetPhotosOutputImpl : GetPhotoDetailUseCase.GetPhotosOutput {
        override fun onSuccess(response: Photo) {
            photo.value = DetailView(response.url, response.name)
        }

        override fun onUnknownError(throwable: Throwable) {
            Timber.i("loadPhotoDetail onUnknownError: $throwable")
            //handleFailure(throwable)
        }
    }
}
