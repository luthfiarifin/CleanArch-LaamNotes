package com.laam.core.usecase.image

import com.laam.core.repository.image.ImageRepository

class GetAllImagesByNoteId(private val repository: ImageRepository) {

    suspend operator fun invoke(id: Long) = repository.getAllImagesByNoteId(id)
}