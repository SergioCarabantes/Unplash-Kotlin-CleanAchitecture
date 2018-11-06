package com.sergio.unsplash.domain.usecase

import com.sergio.unsplash.domain.model.Photo
import com.sergio.unsplash.domain.repository.UnsplashRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(private val usersRepository: UnsplashRepository
) : UseCase<GetPhotosUseCase.GetPhotosRequest, GetPhotosUseCase.GetPhotosOutput>() {

    override fun execute(request: GetPhotosRequest, output: GetPhotosOutput): Disposable {
        return usersRepository.getPhotos(request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(output::onSuccess,
                output::onUnknownError)
    }

    data class GetPhotosRequest(val page: Int)

    interface GetPhotosOutput: Output {
        fun onSuccess(photoList: List<Photo>)
    }
}

