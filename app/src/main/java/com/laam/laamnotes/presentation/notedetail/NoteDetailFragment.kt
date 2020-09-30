package com.laam.laamnotes.presentation.notedetail

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.laam.laamnotes.R
import com.laam.laamnotes.databinding.FragmentNoteDetailBinding
import com.laam.laamnotes.presentation.common.BaseFragment

class NoteDetailFragment : BaseFragment<FragmentNoteDetailBinding, NoteDetailViewModel>(),
    NoteDetailContract.View {

    override fun getViewModel(): Class<NoteDetailViewModel> = NoteDetailViewModel::class.java

    override fun getLayoutId(): Int = R.layout.fragment_note_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        viewBinding.viewModel = viewModel
        viewModel.setNavigator(this)

        arguments?.let { setUpVariable(it) }
    }

    private fun setUpVariable(it: Bundle) {
        viewModel.noteId.set(NoteDetailFragmentArgs.fromBundle(it).noteId)

        if (viewModel.noteId.get() != 0L) {
            viewModel.getCurrentNote()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_save, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_save -> {
                viewModel.saveNote()
                true
            }
            else ->
                return super.onOptionsItemSelected(item)
        }
    }

    override fun onSaveNoteSucceed() {
        view?.let {
            Snackbar.make(it, "Done!", Snackbar.LENGTH_SHORT).show()
            Navigation.findNavController(it).popBackStack()
        }
    }
}