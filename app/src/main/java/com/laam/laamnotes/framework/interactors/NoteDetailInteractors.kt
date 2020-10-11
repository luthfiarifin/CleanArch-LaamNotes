package com.laam.laamnotes.framework.interactors

import com.laam.core.usecase.image.AddImage
import com.laam.core.usecase.note.AddNote
import com.laam.core.usecase.note.GetNote
import com.laam.core.usecase.note.RemoveNote

data class NoteDetailInteractors(
    val addNote: AddNote,
    val getNote: GetNote,
    val removeNote: RemoveNote,
    val addImage: AddImage
)