package com.sergio.unsplash.data.repository

import com.sergio.unsplash.data.model.mapToDomain
import com.sergio.unsplash.data.remote.UnsplashService
import com.sergio.unsplash.domain.model.Photo
import com.sergio.unsplash.domain.repository.UnsplashRepository
import io.reactivex.Single

class UnsplashRepositoryImpl constructor(
    private val unsplashService: UnsplashService
) : UnsplashRepository {

    override fun getPhotos(): Single<List<Photo>> {
        return unsplashService.getPhotos()
            .map { it.mapToDomain() }
    }
}
