package com.laam.laamnotes.presentation.notelist

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.laam.core.data.Note
import com.laam.laamnotes.framework.interactors.NoteListInteractors
import com.laam.laamnotes.presentation.common.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteListViewModel @Inject constructor(
    private val interactors: NoteListInteractors
) : BaseViewModel<NoteListContractor.View>(),
    NoteListContractor.ViewModel {

    init {
        getAllNotes()
    }

    private val _noteLiveData = MutableLiveData<List<Note>>()

    val noteListData
        get() = _noteLiveData as LiveData<List<Note>>

    val noteLoading = ObservableBoolean(true)

    override fun onAddNote() {
        navigator?.onAddNoteClickListener()
    }

    override fun getAllNotes() {
        coroutineScopeIO.launch {
            val noteList = interactors.getAllNotes()
            _noteLiveData.postValue(noteList)
            noteLoading.set(false)
        }
    }
}