package com.sergio.unsplash.di.modules

import com.sergio.unsplash.data.remote.UnsplashApi
import com.sergio.unsplash.data.repository.UnsplashRepositoryImpl
import com.sergio.unsplash.domain.repository.UnsplashRepository
import dagger.Module
import dagger.Provides


@Module
class RepositoryModule {

    @Provides internal fun provideUnsplashRemote(api: UnsplashApi): UnsplashRepository =
            UnsplashRepositoryImpl(api)

}
