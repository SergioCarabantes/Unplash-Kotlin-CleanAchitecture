package com.sergio.unsplash.di.modules

import com.sergio.unsplash.data.remote.UnsplashApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServicesModule {

    @Provides
    @Singleton
    fun provideUsersService(retrofit: Retrofit): UnsplashApi {
        return retrofit.create<UnsplashApi>(UnsplashApi::class.java)
    }
}
