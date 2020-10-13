package com.laam.laamnotes.framework.di.module

import com.laam.core.repository.image.ImageRepository
import com.laam.core.repository.note.NoteRepository
import com.laam.laamnotes.framework.datasource.ImageDataSource
import com.laam.laamnotes.framework.datasource.NoteDataSource
import dagger.Module
import dagger.Provides

@Module
object RepositoryModule {

    @Provides
    @JvmStatic
    fun provideNoteRepository(dataSource: NoteDataSource) =
        NoteRepository(dataSource)

    @Provides
    @JvmStatic
    fun provideImageRepository(dataSource: ImageDataSource) =
        ImageRepository(dataSource)
}