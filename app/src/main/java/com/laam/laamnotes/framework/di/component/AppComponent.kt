package com.laam.laamnotes.framework.di.component

import android.app.Application
import com.laam.laamnotes.framework.di.builder.ActivityBuilder
import com.laam.laamnotes.framework.di.module.*
import com.laam.laamnotes.presentation.NotesApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilder::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        DatabaseModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent : AndroidInjector<NotesApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}