package com.example.homework1_7m.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.homework1_7m.App
import com.example.homework1_7m.data.mapper.NoteMapper
import com.example.homework1_7m.domain.model.Note
import com.example.homework1_7m.domain.repository.NoteRepository
import com.example.homework1_7m.utils.Resource
import kotlinx.coroutines.Dispatchers

class NoteRepositoryImpl: NoteRepository {

//DRY - don't repeat yourself
    private val noteMapper = NoteMapper()
    private val noteDao = App.noteDao


    override fun addNote(note: Note): LiveData<Resource<Unit>> = liveData(Dispatchers.IO) {
        noteDao.addNote(noteMapper.noteToNoteEntity(note))
    }

    override fun getAllNotes(): LiveData<Resource<List<Note>>> = liveData(Dispatchers.IO) {
        noteDao.getAllNotes()
    }

    override fun deleteNote(note: Note): LiveData<Resource<Unit>> = liveData(Dispatchers.IO) {
        noteDao.deleteNote(noteMapper.noteToNoteEntity(note))
    }

    override fun editNote(id: Int, note: Note): LiveData<Resource<Unit>> = liveData(Dispatchers.IO) {
        noteDao.editNote(noteMapper.noteToNoteEntity(note))
    }


}