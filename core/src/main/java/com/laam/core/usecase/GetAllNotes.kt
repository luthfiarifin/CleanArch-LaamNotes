package com.laam.core.usecase

import com.laam.core.repository.NoteRepository

class GetAllNotes(private val repository: NoteRepository) {

    suspend operator fun invoke() = repository.getAllNotes()
}