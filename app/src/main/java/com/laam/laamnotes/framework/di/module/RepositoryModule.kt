package com.laam.laamnotes.framework.di.module

import com.laam.core.repository.NoteRepository
import com.laam.laamnotes.framework.RoomNoteDataSource
import dagger.Module
import dagger.Provides

@Module
object RepositoryModule {

    @Provides
    @JvmStatic
    fun provideNoteRepository(dataSource: RoomNoteDataSource) =
        NoteRepository(dataSource)
}