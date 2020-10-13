package com.laam.core.usecase.image

import com.laam.core.data.Image
import com.laam.core.repository.image.ImageRepository

class AddImage(private val repository: ImageRepository) {

    suspend operator fun invoke(image: Image) = repository.addImage(image)
}