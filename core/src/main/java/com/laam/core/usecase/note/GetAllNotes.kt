package com.laam.core.usecase.note

import com.laam.core.repository.note.NoteRepository

class GetAllNotes(private val repository: NoteRepository) {

    suspend operator fun invoke() = repository.getAllNotes()
}