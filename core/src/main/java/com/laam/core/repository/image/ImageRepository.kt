package com.laam.core.repository.image

import com.laam.core.data.Image

class ImageRepository(private val dataSource: ImageDataSource) {

    suspend fun addImage(image: Image) = dataSource.add(image)

    suspend fun getAllImagesByNoteId(id: Long) = dataSource.getAllByNoteId(id)

    suspend fun getImageByNoteId(id: Long) = dataSource.getByNoteId(id)

    suspend fun removeImage(image: Image) = dataSource.remove(image)
}