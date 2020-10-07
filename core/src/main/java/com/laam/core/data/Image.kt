package com.laam.core.data

data class Image(
    var path: String,
    var creationTime: Long,
    var noteId: Long,
    var id: Long = 0
)