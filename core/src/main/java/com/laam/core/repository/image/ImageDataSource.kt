package com.laam.core.repository.image

import com.laam.core.data.Image

interface ImageDataSource {

    suspend fun add(image: Image)

    suspend fun getAllByNoteId(noteId: Long): List<Image>

    suspend fun getByNoteId(noteId: Long): Image?

    suspend fun remove(image: Image)
}