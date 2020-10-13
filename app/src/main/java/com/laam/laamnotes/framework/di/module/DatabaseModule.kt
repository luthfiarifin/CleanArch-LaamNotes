package com.laam.laamnotes.framework.di.module

import android.app.Application
import com.laam.laamnotes.framework.db.AppDatabase
import dagger.Module
import dagger.Provides

@Module
object DatabaseModule {

    @Provides
    @JvmStatic
    fun provideAppDatabase(application: Application) =
        AppDatabase.create(application)

    @Provides
    @JvmStatic
    fun provideNoteDao(appDatabase: AppDatabase) =
        appDatabase.noteDao()

    @Provides
    @JvmStatic
    fun provideImageDao(appDatabase: AppDatabase) =
        appDatabase.imageDao()
}