package com.sergio.unsplash.domain.usecase

import com.sergio.unsplash.domain.model.Photo
import com.sergio.unsplash.domain.repository.UnsplashRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetPhotoDetailUseCase @Inject constructor(private val usersRepository: UnsplashRepository
) : UseCase<GetPhotoDetailUseCase.Request, GetPhotoDetailUseCase.GetPhotosOutput>() {

    override fun execute(request: Request, output: GetPhotosOutput): Disposable {
        return usersRepository.getPhotoDetail(request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(output::onSuccess,
                output::onUnknownError)
    }

    data class Request(val photoId: String)

    interface GetPhotosOutput: Output {
        fun onSuccess(response: Photo)
    }
}

