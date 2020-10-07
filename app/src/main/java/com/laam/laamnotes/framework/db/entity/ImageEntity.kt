package com.laam.laamnotes.framework.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.laam.core.data.Image

@Entity(
    tableName = "image",
    foreignKeys = [
        ForeignKey(
            entity = NoteEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("note_id"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ImageEntity(
    val path: String,
    @ColumnInfo(name = "creation_time") val creationTime: Long,
    @ColumnInfo(name = "note_id", index = true) val noteId: Long,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
) {
    companion object {
        fun mapFromImage(image: Image) =
            ImageEntity(image.path, image.creationTime, image.noteId, image.id)
    }

    fun mapToImage() = Image(path, creationTime, noteId, id)
}