package com.example.homework1_7m.domain.repository

import androidx.lifecycle.LiveData
import com.example.homework1_7m.domain.model.Note
import com.example.homework1_7m.utils.Resource

interface NoteRepository {

    fun addNote(note: Note): LiveData<Resource<Unit>>

    fun getAllNotes(): LiveData<Resource<List<Note>>>

    fun deleteNote(note: Note) : LiveData<Resource<Unit>>

    fun editNote(id: Int, note: Note) : LiveData<Resource<Unit>>

}