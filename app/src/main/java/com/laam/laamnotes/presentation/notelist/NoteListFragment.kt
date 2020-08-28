package com.laam.laamnotes.presentation.notelist

import android.os.Bundle
import android.view.View
import com.laam.laamnotes.R
import com.laam.laamnotes.databinding.FragmentNoteListBinding
import com.laam.laamnotes.presentation.common.BaseFragment

class NoteListFragment : BaseFragment<FragmentNoteListBinding, NoteListViewModel>(),
    NoteListNavigator {
    override fun getViewModel(): Class<NoteListViewModel> = NoteListViewModel::class.java

    override fun getLayoutId(): Int = R.layout.fragment_note_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}