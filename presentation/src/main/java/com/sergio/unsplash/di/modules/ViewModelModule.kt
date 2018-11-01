package com.sergio.unsplash.di.modules

import androidx.lifecycle.ViewModelProvider
import com.sergio.unsplash.common.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
