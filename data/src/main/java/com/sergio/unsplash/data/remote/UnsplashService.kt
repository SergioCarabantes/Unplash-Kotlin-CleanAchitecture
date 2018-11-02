package com.sergio.unsplash.data.remote

import com.sergio.unsplash.data.model.PhotoModel
import io.reactivex.Single
import retrofit2.http.GET

interface UnsplashService {

    @GET("/photos")
    fun getPhotos(): Single<List<PhotoModel>>
}
