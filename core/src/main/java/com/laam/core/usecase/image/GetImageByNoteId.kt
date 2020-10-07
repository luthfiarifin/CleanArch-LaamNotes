package com.laam.core.usecase.image

import com.laam.core.repository.image.ImageRepository

class GetImageByNoteId(private val repository: ImageRepository) {

    suspend operator fun invoke(id: Long) = repository.getImageByNoteId(id)
}