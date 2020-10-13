package com.laam.core.usecase.note

import com.laam.core.data.Note
import com.laam.core.repository.note.NoteRepository

class RemoveNote(private val repository: NoteRepository) {

    suspend operator fun invoke(note: Note) = repository.removeNote(note)
}