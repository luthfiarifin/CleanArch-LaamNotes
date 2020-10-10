package com.laam.laamnotes.presentation.notedetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.laam.laamnotes.R
import com.laam.laamnotes.databinding.ItemImagesBinding

class NoteDetailImageAdapter(val listener: Listener) :
    RecyclerView.Adapter<NoteDetailImageAdapter.ViewHolder>() {

    val noteList = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_images,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = noteList.size

    fun submitList(list: ArrayList<String>) {
        noteList.addAll(list)
        notifyDataSetChanged()
    }

    fun deleteList(position: Int) {
        noteList.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class ViewHolder(private val binding: ItemImagesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.imagePath = noteList[position]

            binding.imageLayout.setOnClickListener { listener.onClick(adapterPosition) }

            binding.imageViewDelete.setOnClickListener { listener.onDeleteClick(adapterPosition) }
        }
    }

    interface Listener {
        fun onClick(index: Int)
        fun onDeleteClick(index: Int)
    }
}
