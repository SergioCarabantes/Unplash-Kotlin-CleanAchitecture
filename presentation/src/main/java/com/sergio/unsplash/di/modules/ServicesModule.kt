package com.sergio.unsplash.di.modules

import com.sergio.unsplash.data.remote.FeedService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServicesModule {

    @Provides
    @Singleton
    fun provideUsersService(retrofit: Retrofit): FeedService {
        return retrofit.create<FeedService>(FeedService::class.java)
    }
}
