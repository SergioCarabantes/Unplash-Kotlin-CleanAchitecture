package com.sergio.unsplash.data.remote

import com.sergio.unsplash.data.model.PhotoModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UnsplashApi {

    @GET("/photos")
    fun getLatestPhotos(@Query("page") page: Int = DEFAULT_PAGE,
                        @Query("per_page") perPage: Int = DEFAULT_ITEMS_PER_PAGE,
                        @Query("order_by") orientation: String = "latest"): Single<List<PhotoModel>>

    @GET("/photos/{id}")
    fun getPhotoDetail(@Path("id") id: String): Single<PhotoModel>

    companion object {
        const val DEFAULT_PAGE = 1
        const val DEFAULT_ITEMS_PER_PAGE = 30
    }
}
