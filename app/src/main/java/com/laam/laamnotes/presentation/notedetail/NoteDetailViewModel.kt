package com.laam.laamnotes.presentation.notedetail

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.databinding.ObservableLong
import com.laam.core.data.Image
import com.laam.core.data.Note
import com.laam.laamnotes.framework.interactors.NoteDetailInteractors
import com.laam.laamnotes.presentation.common.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteDetailViewModel @Inject constructor(
    private val interactors: NoteDetailInteractors
) : BaseViewModel<NoteDetailContract.View>(), NoteDetailContract.ViewModel {

    val noteId = ObservableLong(0)
    val noteTitle = ObservableField<String>()
    val noteContent = ObservableField<String>()

    private val noteCreationTime = ObservableLong(0)
    private val noteUpdateTime = ObservableLong(0)

    val imagePathList = ObservableArrayList<String>()

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
            val addNote = interactors.addNote(note)
            imagePathList.forEach { interactors.addImage(Image(it, currentTime, addNote)) }
        }

        navigator?.onSaveNoteSucceed()
    }

    override fun getCurrentNote() {
        coroutineScopeIO.launch {
            interactors.getNote(noteId.get())?.let { currentNote ->
                noteTitle.set(currentNote.title)
                noteContent.set(currentNote.content)
                noteCreationTime.set(currentNote.creationTime)
                noteUpdateTime.set(currentNote.updateTime)
            }

            interactors.getAllImagesByNoteId(noteId.get()).let { images ->
                if (images.isNotEmpty()) withContext(Dispatchers.Main) { addImage(images.map { it.path } as ArrayList<String>) }
            }
        }
    }

    override fun deleteNote() {
        val note = Note(
            noteTitle.get().toString(),
            noteContent.get().toString(),
            noteCreationTime.get(),
            noteUpdateTime.get(),
            noteId.get()
        )

        coroutineScopeIO.launch { interactors.removeNote(note) }
        navigator?.onSaveNoteSucceed()
    }

    override fun addImage(path: String) {
        imagePathList.add(path)
        navigator?.onAddImageSucceed(arrayListOf(path))
    }

    override fun addImage(paths: ArrayList<String>) {
        imagePathList.addAll(paths)
        navigator?.onAddImageSucceed(paths)
    }

    override fun removeImage(index: Int): Int {
        imagePathList.apply { removeAt(index) }
        return index
    }
}