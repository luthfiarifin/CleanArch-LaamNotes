package com.laam.laamnotes.framework.datasource

import com.laam.core.data.Note
import com.laam.core.repository.note.NoteDataSource
import com.laam.laamnotes.framework.db.dao.NoteDao
import com.laam.laamnotes.framework.db.entity.NoteEntity
import javax.inject.Inject

class NoteDataSource @Inject constructor(private val noteDao: NoteDao) :
    NoteDataSource {

    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.mapFromNote(note))

    override suspend fun get(id: Long) = noteDao.getNoteEntity(id)?.mapToNote()

    override suspend fun getAll() = noteDao.getAllNoteEntity().map { it.mapToNote() }

    override suspend fun remove(note: Note) = noteDao.deleteNoteEntity(NoteEntity.mapFromNote(note))
}
