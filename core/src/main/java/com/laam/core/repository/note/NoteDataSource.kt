package com.laam.core.repository.note

import com.laam.core.data.Note

interface NoteDataSource {

    suspend fun add(note: Note): Long

    suspend fun get(id: Long): Note?

    suspend fun getAll(): List<Note>

    suspend fun remove(note: Note)
}