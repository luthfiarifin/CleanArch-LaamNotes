package com.laam.laamnotes.presentation.notelist

interface NoteListContractor {

    interface ViewModel {
        fun onAddNote(view: android.view.View)
        fun getAllNotes()
    }

    interface View {
        fun onAddNoteClickListener(view: android.view.View)
    }
}