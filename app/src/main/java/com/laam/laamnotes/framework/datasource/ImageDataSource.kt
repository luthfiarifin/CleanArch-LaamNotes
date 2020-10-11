package com.laam.laamnotes.framework.datasource

import com.laam.core.data.Image
import com.laam.core.repository.image.ImageDataSource
import com.laam.laamnotes.framework.db.dao.ImageDao
import com.laam.laamnotes.framework.db.entity.ImageEntity
import javax.inject.Inject

class ImageDataSource @Inject constructor(private val imageDao: ImageDao) :
    ImageDataSource {

    override suspend fun add(image: Image) =
        imageDao.addImage(ImageEntity.mapFromImage(image))

    override suspend fun getAllByNoteId(noteId: Long): List<Image> =
        imageDao.getAllImageEntitiesByNoteId(noteId).map { it.mapToImage() }

    override suspend fun getByNoteId(noteId: Long): Image? =
        imageDao.getImageEntityByNoteId(noteId)?.mapToImage()

    override suspend fun remove(image: Image) =
        imageDao.deleteImageEntity(ImageEntity.mapFromImage(image))
}
