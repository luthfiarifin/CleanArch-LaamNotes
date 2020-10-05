package com.laam.laamnotes.framework.interactors

import com.laam.core.usecase.AddNote
import com.laam.core.usecase.GetAllNotes
import com.laam.core.usecase.GetNote
import com.laam.core.usecase.RemoveNote

data class NoteDetailInteractors(
    val addNote: AddNote,
    val getNote: GetNote,
    val removeNote: RemoveNote
)