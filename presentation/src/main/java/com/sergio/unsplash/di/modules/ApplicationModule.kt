package com.sergio.unsplash.di.modules

import android.content.Context
import com.sergio.unsplash.UnsplashApplication
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: UnsplashApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}
