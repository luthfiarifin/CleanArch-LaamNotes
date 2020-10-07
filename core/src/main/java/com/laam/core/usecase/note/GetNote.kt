package com.laam.core.usecase.note

import com.laam.core.repository.note.NoteRepository

class GetNote(private val repository: NoteRepository) {

    suspend operator fun invoke(id: Long) = repository.getNote(id)
}