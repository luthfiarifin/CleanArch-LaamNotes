package com.laam.laamnotes.presentation.notedetail

interface NoteDetailContract {

    interface ViewModel {
        fun saveNote()
        fun getCurrentNote()
        fun deleteNote()
    }

    interface View {
        fun onSaveNoteSucceed()
    }
}