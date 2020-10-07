package com.laam.laamnotes.framework.di.module

import com.laam.core.repository.note.NoteRepository
import com.laam.core.usecase.note.AddNote
import com.laam.core.usecase.note.GetAllNotes
import com.laam.core.usecase.note.GetNote
import com.laam.core.usecase.note.RemoveNote
import com.laam.laamnotes.framework.interactors.NoteDetailInteractors
import com.laam.laamnotes.framework.interactors.NoteListInteractors
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

    @Provides
    @JvmStatic
    fun provideNoteListInteractors(repository: NoteRepository) =
        NoteListInteractors(
            GetAllNotes(repository)
        )
}