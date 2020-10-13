package com.laam.core.repository.note

import com.laam.core.data.Note

class NoteRepository(private val dataSource: NoteDataSource) {

    suspend fun addNote(note: Note): Long = dataSource.add(note)

    suspend fun getNote(id: Long) = dataSource.get(id)

    suspend fun getAllNotes() = dataSource.getAll()

    suspend fun removeNote(note: Note) = dataSource.remove(note)
}