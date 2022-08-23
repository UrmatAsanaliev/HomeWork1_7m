package com.example.homework1_7m.domain.use_cases

import com.example.homework1_7m.domain.model.Note
import com.example.homework1_7m.domain.repository.NoteRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(private val repo: NoteRepository) {

    fun addNote(note: Note) = repo.addNote(note)

}