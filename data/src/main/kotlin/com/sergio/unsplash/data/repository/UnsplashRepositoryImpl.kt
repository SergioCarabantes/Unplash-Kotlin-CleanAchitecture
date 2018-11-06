package com.sergio.unsplash.data.repository

import com.sergio.unsplash.data.model.mapToDomain
import com.sergio.unsplash.data.remote.UnsplashApi
import com.sergio.unsplash.domain.model.Photo
import com.sergio.unsplash.domain.repository.UnsplashRepository
import com.sergio.unsplash.domain.usecase.GetPhotosUseCase
import io.reactivex.Single

class UnsplashRepositoryImpl constructor(
    private val unsplashApi: UnsplashApi
) : UnsplashRepository {

    override fun getPhotos(request: GetPhotosUseCase.GetPhotosRequest): Single<List<Photo>> {
        return  unsplashApi.getPhotos(request.page).map { it.mapToDomain() }
    }
}
