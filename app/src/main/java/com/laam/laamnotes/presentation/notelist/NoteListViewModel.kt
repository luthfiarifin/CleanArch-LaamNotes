package com.laam.laamnotes.presentation.notelist

import android.view.View
import com.laam.laamnotes.presentation.common.BaseViewModel
import javax.inject.Inject

class NoteListViewModel @Inject constructor() : BaseViewModel<NoteListContractor.View>(),
    NoteListContractor.ViewModel {

    override fun onAddNote(view: View) {
        navigator?.onAddNoteClickListener(view)
    }
}