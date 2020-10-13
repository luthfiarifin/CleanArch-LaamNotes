package com.laam.laamnotes.presentation.notedetail

import android.os.Bundle

interface NoteDetailContract {

    interface ViewModel {
        fun saveNote()
        fun getCurrentNote()
        fun deleteNote()

        fun addImage(path: String)
        fun addImage(paths: ArrayList<String>)
        fun removeImage(index: Int): Int
    }

    interface View {
        fun setUpVariable(it: Bundle)
        fun initUi()
        fun addImage()
        fun checkReadPermission(): Boolean
        fun deleteNote()
        fun onSaveNoteSucceed()
        fun onAddImageSucceed(paths: ArrayList<String>)
    }
}