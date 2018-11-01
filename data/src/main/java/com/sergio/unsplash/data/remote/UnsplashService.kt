package com.sergio.unsplash.data.remote

import retrofit2.http.GET

interface FeedService {

    @GET("/photos")
    fun getPhotos()
}
