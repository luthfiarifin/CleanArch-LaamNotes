package com.laam.laamnotes.presentation.notelist

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.laam.laamnotes.R
import com.laam.laamnotes.databinding.FragmentNoteListBinding
import com.laam.laamnotes.presentation.common.BaseFragment

class NoteListFragment : BaseFragment<FragmentNoteListBinding, NoteListViewModel>(),
    NoteListContractor.View {
    override fun getViewModel(): Class<NoteListViewModel> = NoteListViewModel::class.java

    override fun getLayoutId(): Int = R.layout.fragment_note_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.viewModel = viewModel
        viewModel.setNavigator(this)
    }

    override fun onAddNoteClickListener(view: View) {
        val action = NoteListFragmentDirections.actionNoteListFragmentToNoteDetailFragment()
        Navigation.findNavController(view).navigate(action)
    }
}