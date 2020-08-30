package com.laam.laamnotes.framework.di.module

import com.laam.core.repository.NoteRepository
import com.laam.core.usecase.AddNote
import com.laam.core.usecase.GetAllNotes
import com.laam.core.usecase.GetNote
import com.laam.core.usecase.RemoveNote
import com.laam.laamnotes.framework.interactors.NoteDetailInteractors
import dagger.Module
import dagger.Provides

@Module
object InteractorsModule {

    @Provides
    @JvmStatic
    fun provideNoteDetailInteractors(repository: NoteRepository) =
        NoteDetailInteractors(
            AddNote(repository),
            GetNote(repository),
            RemoveNote(repository)
        )
}