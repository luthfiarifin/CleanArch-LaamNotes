package com.laam.laamnotes.presentation.notedetail

interface NoteDetailContract {

    interface ViewModel {
        fun saveNote()
    }

    interface View {
        fun onSaveNoteSucceed()
    }
}