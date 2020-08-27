package com.laam.core.usecase

import com.laam.core.data.Note
import com.laam.core.repository.NoteRepository

class AddNote(private val repository: NoteRepository) {

    suspend operator fun invoke(note: Note) = repository.addNote(note)
}