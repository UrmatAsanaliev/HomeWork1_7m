package com.example.homework1_7m.domain.repository

import androidx.lifecycle.LiveData
import com.example.homework1_7m.domain.model.Note
import com.example.homework1_7m.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun addNote(note: Note): Flow<Resource<Unit>>

    fun getAllNotes(): Flow<Resource<List<Note>>>

    fun deleteNote(note: Note) : Flow<Resource<Unit>>

    fun editNote(id: Int, note: Note) : Flow<Resource<Unit>>

}