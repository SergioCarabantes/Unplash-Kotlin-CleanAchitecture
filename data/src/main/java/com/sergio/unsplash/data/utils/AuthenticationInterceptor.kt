package com.sergio.unsplash.data.utils

import com.sergio.unsplash.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class AuthenticationInterceptor @Inject
constructor() : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()
        request = request.newBuilder()
            .addHeader(AUTHORIZATION_HEADER_KEY, BuildConfig.API_UNSPLASH_KEY)
            .addHeader(AUTHORIZATION_HEADER_CONTENT_TYPE_KEY, AUTHORIZATION_HEADER_CONTENT_TYPE_VALUE)
            .build()

        return chain.proceed(request)
    }

    companion object {

        private const val AUTHORIZATION_HEADER_KEY = "Authorization"
        private const val AUTHORIZATION_HEADER_CONTENT_TYPE_KEY = "Content-type"
        private const val AUTHORIZATION_HEADER_CONTENT_TYPE_VALUE = "application/x-www-form-urlencoded;charset=UTF-8"
    }

}
