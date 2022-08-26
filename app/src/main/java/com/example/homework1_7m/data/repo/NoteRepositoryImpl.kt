package com.example.homework1_7m.data.repo

import com.example.homework1_7m.core.BaseRepository
import com.example.homework1_7m.data.mapper.NoteMapper
import com.example.homework1_7m.data.room.NoteDao
import com.example.homework1_7m.domain.model.Note
import com.example.homework1_7m.domain.repository.NoteRepository
import com.example.homework1_7m.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
): NoteRepository, BaseRepository() {

//DRY - don't repeat yourself
    private val noteMapper = NoteMapper()



    override fun addNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.addNote(noteMapper.noteToNoteEntity(note))
    }

    override fun getAllNotes(): Flow<Resource<List<Note>>> = doRequest {
        noteDao.getAllNotes().map { noteEntity -> noteMapper.noteEntityToNote(noteEntity) }
    }

    override fun deleteNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.deleteNote(noteMapper.noteToNoteEntity(note))
    }

    override fun editNote(id: Int, note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.editNote(noteMapper.noteToNoteEntity(note))
    }
}