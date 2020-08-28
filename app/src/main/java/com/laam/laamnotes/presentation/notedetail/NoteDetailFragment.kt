package com.laam.laamnotes.presentation.notedetail

import android.os.Bundle
import android.view.View
import com.laam.laamnotes.R
import com.laam.laamnotes.databinding.FragmentNoteDetailBinding
import com.laam.laamnotes.presentation.common.BaseFragment

class NoteDetailFragment : BaseFragment<FragmentNoteDetailBinding, NoteDetailViewModel>(),
    NoteDetailNavigator {

    override fun getViewModel(): Class<NoteDetailViewModel> = NoteDetailViewModel::class.java

    override fun getLayoutId(): Int = R.layout.fragment_note_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}