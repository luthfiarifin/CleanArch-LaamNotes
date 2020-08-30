package com.laam.laamnotes.framework.interactors

import com.laam.core.usecase.AddNote
import com.laam.core.usecase.GetAllNotes
import com.laam.core.usecase.GetNote
import com.laam.core.usecase.RemoveNote

data class NoteInteractors(
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote
)