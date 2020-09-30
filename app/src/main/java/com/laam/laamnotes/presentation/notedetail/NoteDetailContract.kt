package com.laam.laamnotes.presentation.notedetail

interface NoteDetailContract {

    interface ViewModel {
        fun saveNote()
        fun getCurrentNote()
    }

    interface View {
        fun onSaveNoteSucceed()
    }
}