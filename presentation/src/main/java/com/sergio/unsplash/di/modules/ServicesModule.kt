package com.sergio.unsplash.di.modules

import com.sergio.unsplash.data.remote.UnsplashService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServicesModule {

    @Provides
    @Singleton
    fun provideUsersService(retrofit: Retrofit): UnsplashService {
        return retrofit.create<UnsplashService>(UnsplashService::class.java)
    }
}
