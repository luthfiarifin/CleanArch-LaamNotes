package com.laam.laamnotes.presentation.notedetail

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.laam.laamnotes.R
import com.laam.laamnotes.databinding.FragmentNoteDetailBinding
import com.laam.laamnotes.presentation.common.BaseFragment
import com.laam.laamnotes.presentation.notedetail.adapter.NoteDetailImageAdapter
import com.laam.laamnotes.presentation.notelist.NoteListFragment
import com.laam.laamnotes.presentation.util.constant.PermissionConstant
import com.laam.laamnotes.presentation.util.constant.RequestConstant
import com.laam.laamnotes.presentation.util.view.NavigationUtil.setNavigationResult
import com.laam.laamnotes.presentation.util.view.ViewUtil.hideKeyboard

class NoteDetailFragment : BaseFragment<FragmentNoteDetailBinding, NoteDetailViewModel>(),
    NoteDetailContract.View, NoteDetailImageAdapter.Listener {

    override fun getViewModel(): Class<NoteDetailViewModel> = NoteDetailViewModel::class.java

    override fun getLayoutId(): Int = R.layout.fragment_note_detail

    private val rvImageAdapter = NoteDetailImageAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        viewBinding.viewModel = viewModel
        viewModel.setNavigator(this)

        arguments?.let { setUpVariable(it) }
        initUi()
    }

    override fun setUpVariable(it: Bundle) {
        viewModel.noteId.set(NoteDetailFragmentArgs.fromBundle(it).noteId)

        if (viewModel.noteId.get() != 0L) {
            viewModel.getCurrentNote()
        }
    }

    override fun initUi() {
        viewBinding.recyclerViewImage.adapter = rvImageAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_save, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)

        if (viewModel.noteId.get() == 0L) {
            menu.findItem(R.id.item_delete).isVisible = false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_save -> {
                viewModel.saveNote()
                true
            }
            R.id.item_delete -> {
                deleteNote()
                true
            }
            R.id.item_add_image -> {
                addImage()
                true
            }
            else ->
                return super.onOptionsItemSelected(item)
        }
    }

    override fun addImage() {
        if (checkReadPermission()) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                PermissionConstant.READ_EXTERNAL_STORAGE
            )
            view?.let {
                Snackbar.make(it, "Read storage permission required", Snackbar.LENGTH_SHORT).show()
            }
        } else {
            Intent().let { i ->
                i.type = "image/*"
                i.action = Intent.ACTION_GET_CONTENT
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                    i.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                }

                startActivityForResult(i, RequestConstant.IMAGE_PICKER_REQUEST_CODE)
            }
        }
    }

    override fun checkReadPermission(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                context?.let {
                    ContextCompat.checkSelfPermission(
                        it,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    )
                } != PackageManager.PERMISSION_GRANTED
    }

    override fun deleteNote() {
        activity?.let {
            AlertDialog.Builder(it)
                .setTitle("Delete note")
                .setMessage("Are you sure want delete this note?")
                .setPositiveButton("Yes") { _, _ ->
                    viewModel.deleteNote()
                }
                .setNegativeButton("Cancel") { _, _ -> }
                .create()
                .show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_CANCELED) {
            return
        }

        when (requestCode) {
            RequestConstant.IMAGE_PICKER_REQUEST_CODE -> {
                if (data?.data != null) {
                    data.data?.let { viewModel.addImage(it.toString()) }
                } else {
                    data?.clipData?.let { clipData ->
                        val pathList = arrayListOf<String>()

                        for (i in 0 until clipData.itemCount) {
                            clipData.getItemAt(i).uri?.let { pathList.add(it.toString()) }
                        }

                        viewModel.addImage(pathList)
                    }
                }
            }
        }
    }

    override fun onSaveNoteSucceed() {
        view?.let {
            setNavigationResult(true, NoteListFragment.KEY_RELOAD_DATA)
            Snackbar.make(it, "Done!", Snackbar.LENGTH_SHORT).show()
            it.hideKeyboard(activity)
            Navigation.findNavController(it).popBackStack()
        }
    }

    override fun onAddImageSucceed(paths: ArrayList<String>) {
        rvImageAdapter.submitList(paths)
    }

    override fun onClick(index: Int) {
        //TODO("onClick")
    }

    override fun onDeleteClick(index: Int) {
        rvImageAdapter.deleteList(viewModel.removeImage(index))
    }
}