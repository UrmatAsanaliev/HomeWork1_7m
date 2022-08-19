package com.example.homework1_7m.presentation.ui.fragment.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1_7m.databinding.ItemNotesBinding
import com.example.homework1_7m.domain.model.Note

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.ViewHolder>(){

    var list = listOf<Note>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNotesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


    inner class ViewHolder(private val binding: ItemNotesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(note: Note){
            binding.txtTitle.text = note.title
            binding.txtDesc.text = note.description
            binding.txtDate.text = note.creationDate
        }
    }
}