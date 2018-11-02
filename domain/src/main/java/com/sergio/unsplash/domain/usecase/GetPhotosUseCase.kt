package com.sergio.unsplash.domain.usecase

import com.sergio.unsplash.domain.model.Photo
import com.sergio.unsplash.domain.repository.UnsplashRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(private val usersRepository: UnsplashRepository
) : UseCase<GetPhotosUseCase.Request, GetPhotosUseCase.GetPhotosOutput>() {

    override fun execute(request: Request, output: GetPhotosOutput): Disposable {
        return usersRepository.getPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(output::onSuccess,
                output::onUnknownError)
    }

    data class Request(val page: Int, val query: String)

    interface GetPhotosOutput: Output {
        fun onSuccess(photoList: List<Photo>)
    }
}

