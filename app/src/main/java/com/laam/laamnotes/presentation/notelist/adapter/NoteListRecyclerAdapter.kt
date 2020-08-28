package com.laam.laamnotes.presentation.notelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.laam.core.data.Note
import com.laam.laamnotes.R
import com.laam.laamnotes.databinding.ItemNotesBinding

class NoteListRecyclerAdapter :
    ListAdapter<Note, NoteListRecyclerAdapter.ViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteListRecyclerAdapter.ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_notes,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteListRecyclerAdapter.ViewHolder, position: Int) {
    }

    inner class ViewHolder(binding: ItemNotesBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Note>() {
            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean =
                oldItem.id == newItem.id
        }
    }
}