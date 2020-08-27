package com.laam.core.usecase

import com.laam.core.repository.NoteRepository

class GetNote(private val repository: NoteRepository) {

    suspend operator fun invoke(id: Long) = repository.getNote(id)
}