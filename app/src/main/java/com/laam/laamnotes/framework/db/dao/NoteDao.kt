package com.laam.laamnotes.framework.db.dao

import androidx.room.*
import com.laam.laamnotes.framework.db.entity.NoteEntity

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNoteEntity(noteEntity: NoteEntity): Long

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteEntity(id: Long): NoteEntity?

    @Query("SELECT * FROM note")
    suspend fun getAllNoteEntity(): List<NoteEntity>

    @Delete
    suspend fun deleteNoteEntity(noteEntity: NoteEntity)
}