package com.laam.laamnotes.framework.di.module

import androidx.lifecycle.ViewModelProvider
import com.laam.laamnotes.framework.di.util.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}