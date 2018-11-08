package com.sergio.unsplash.domain.repository

import com.sergio.unsplash.domain.model.Photo
import com.sergio.unsplash.domain.usecase.GetPhotoDetailUseCase
import com.sergio.unsplash.domain.usecase.GetPhotosUseCase
import io.reactivex.Single

interface UnsplashRepository {

    fun getPhotos(request: GetPhotosUseCase.Request): Single<List<Photo>>

    fun getPhotoDetail(request: GetPhotoDetailUseCase.Request): Single<Photo>
}
