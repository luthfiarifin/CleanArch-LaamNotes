package com.laam.laamnotes.presentation.notedetail

import androidx.databinding.ObservableField
import com.laam.core.data.Note
import com.laam.laamnotes.framework.interactors.NoteDetailInteractors
import com.laam.laamnotes.presentation.common.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteDetailViewModel @Inject constructor(
    private val interactors: NoteDetailInteractors
) : BaseViewModel<NoteDetailContract.View>(), NoteDetailContract.ViewModel {
    val noteTitle = ObservableField<String>()
    val noteContent = ObservableField<String>()

    override fun saveNote() {
        if (noteTitle.get().isNullOrEmpty() || noteContent.get().isNullOrEmpty()) {
            return
        }

        val currentTime = System.currentTimeMillis()
        val note = Note(
            noteTitle.get().toString(),
            noteContent.get().toString(),
            currentTime,
            currentTime
        )

        coroutineScopeIO.launch {
            interactors.addNote(note)
            navigator?.onSaveNoteSucceed()
        }
    }

}