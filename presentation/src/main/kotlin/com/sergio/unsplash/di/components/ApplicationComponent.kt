package com.sergio.unsplash.di.components

import com.sergio.unsplash.UnsplashApplication
import com.sergio.unsplash.di.modules.*
import com.sergio.unsplash.features.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    ViewModelModule::class,
    ServicesModule::class,
    NetworkModule::class,
    RepositoryModule::class])
interface ApplicationComponent {

    fun inject(application: UnsplashApplication)

    fun inject(homeFragment: HomeFragment)
}
