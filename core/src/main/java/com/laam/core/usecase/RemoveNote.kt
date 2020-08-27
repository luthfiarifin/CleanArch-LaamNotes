package com.laam.core.usecase

import com.laam.core.data.Note
import com.laam.core.repository.NoteRepository

class RemoveNote(private val repository: NoteRepository) {

    suspend operator fun invoke(note: Note) = repository.removeNote(note)
}