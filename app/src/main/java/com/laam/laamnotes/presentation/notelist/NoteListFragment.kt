package com.laam.laamnotes.presentation.notelist

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.laam.laamnotes.R
import com.laam.laamnotes.databinding.FragmentNoteListBinding
import com.laam.laamnotes.presentation.common.BaseFragment
import com.laam.laamnotes.presentation.notelist.adapter.NoteListRecyclerAdapter

class NoteListFragment : BaseFragment<FragmentNoteListBinding, NoteListViewModel>(),
    NoteListContractor.View, NoteListRecyclerAdapter.Listener {

    private val rvAdapter = NoteListRecyclerAdapter(this)

    override fun getViewModel(): Class<NoteListViewModel> = NoteListViewModel::class.java

    override fun getLayoutId(): Int = R.layout.fragment_note_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.viewModel = viewModel
        viewModel.setNavigator(this)

        initUi()
        observeNotes()
    }

    private fun initUi() {
        viewBinding.recyclerView.adapter = rvAdapter
    }

    private fun observeNotes() {
        viewModel.noteListData.observe(viewLifecycleOwner, Observer {
            rvAdapter.submitList(it.sortedByDescending { note -> note.updateTime })
        })
    }

    override fun onAddNoteClickListener() {
        goToNoteDetails()
    }

    override fun onClickListener(id: Long) {
        goToNoteDetails(id)
    }

    private fun goToNoteDetails(id: Long = 0L) {
        val action = NoteListFragmentDirections.actionNoteListFragmentToNoteDetailFragment(id)
        view?.let { Navigation.findNavController(it).navigate(action) }
    }
}