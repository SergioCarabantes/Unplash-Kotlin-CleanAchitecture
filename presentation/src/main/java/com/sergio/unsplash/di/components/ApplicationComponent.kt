package com.sergio.unsplash.di.components

import com.sergio.unsplash.UnsplashApplication
import com.sergio.unsplash.di.modules.ApplicationModule
import com.sergio.unsplash.di.modules.NetworkModule
import com.sergio.unsplash.di.modules.ServicesModule
import com.sergio.unsplash.di.modules.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    ViewModelModule::class,
    ServicesModule::class,
    NetworkModule::class])
interface ApplicationComponent {

    fun inject(application: UnsplashApplication)
}
