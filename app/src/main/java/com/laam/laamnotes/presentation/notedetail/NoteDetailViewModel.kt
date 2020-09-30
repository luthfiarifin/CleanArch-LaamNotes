package com.laam.laamnotes.presentation.notedetail

import androidx.databinding.ObservableField
import androidx.databinding.ObservableLong
import com.laam.core.data.Note
import com.laam.laamnotes.framework.interactors.NoteDetailInteractors
import com.laam.laamnotes.presentation.common.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteDetailViewModel @Inject constructor(
    private val interactors: NoteDetailInteractors
) : BaseViewModel<NoteDetailContract.View>(), NoteDetailContract.ViewModel {

    val noteId = ObservableLong(0)
    val noteTitle = ObservableField<String>()
    val noteContent = ObservableField<String>()

    private val noteCreationTime = ObservableLong(0)
    private val noteUpdateTime = ObservableLong(0)

    override fun saveNote() {
        if (noteTitle.get().isNullOrEmpty() || noteContent.get().isNullOrEmpty()) {
            return
        }

        val currentTime = System.currentTimeMillis()
        val note = Note(
            noteTitle.get().toString(),
            noteContent.get().toString(),
            if (noteCreationTime.get() != 0L) currentTime else noteCreationTime.get(),
            currentTime,
            noteId.get()
        )

        coroutineScopeIO.launch {
            interactors.addNote(note)
            navigator?.onSaveNoteSucceed()
        }
    }

    override fun getCurrentNote() {
        coroutineScopeIO.launch {
            interactors.getNote(noteId.get())?.let { currentNote ->
                noteTitle.set(currentNote.title)
                noteContent.set(currentNote.content)
                noteCreationTime.set(currentNote.creationTime)
                noteUpdateTime.set(currentNote.updateTime)
            }
        }
    }

    override fun deleteNote() {
        coroutineScopeIO.launch {
            val note = Note(
                noteTitle.get().toString(),
                noteContent.get().toString(),
                noteCreationTime.get(),
                noteUpdateTime.get(),
                noteId.get()
            )

            interactors.removeNote(note)
            navigator?.onSaveNoteSucceed()
        }
    }

}