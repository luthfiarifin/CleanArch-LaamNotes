package com.laam.laamnotes.presentation.notelist

interface NoteListContractor {

    interface ViewModel {
        fun onAddNote()
        fun getAllNotes()
    }

    interface View {
        fun onAddNoteClickListener()
    }
}