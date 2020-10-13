package com.laam.laamnotes.framework.db.dao

import androidx.room.*
import com.laam.laamnotes.framework.db.entity.ImageEntity

@Dao
interface ImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImage(imageEntity: ImageEntity)

    @Query("SELECT * FROM image WHERE note_id = :id")
    suspend fun getAllImageEntitiesByNoteId(id: Long): List<ImageEntity>

    @Query("SELECT * FROM image WHERE note_id = :id LIMIT 1")
    suspend fun getImageEntityByNoteId(id: Long): ImageEntity?

    @Delete
    suspend fun deleteImageEntity(imageEntity: ImageEntity)
}