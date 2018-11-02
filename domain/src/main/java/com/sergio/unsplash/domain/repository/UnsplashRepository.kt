package com.sergio.unsplash.domain.repository

import com.sergio.unsplash.domain.model.Photo
import io.reactivex.Single

interface UnsplashRepository {

    fun getPhotos(): Single<List<Photo>>
}
