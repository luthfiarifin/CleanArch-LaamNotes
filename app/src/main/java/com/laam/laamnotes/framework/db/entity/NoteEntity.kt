package com.laam.laamnotes.framework.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.laam.core.data.Note

@Entity(tableName = "note")
data class NoteEntity(
    val title: String,
    val content: String,
    @ColumnInfo(name = "creation_time") val creationTime: Long,
    @ColumnInfo(name = "update_time") val updateTime: Long,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
) {
    companion object {
        fun mapFromNote(note: Note) =
            NoteEntity(note.title, note.content, note.creationTime, note.updateTime, note.id)
    }

    fun mapToNote() = Note(title, content, creationTime, updateTime, id)
}