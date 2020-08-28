package com.laam.laamnotes.framework.di.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.laam.laamnotes.util.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelProviderFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}