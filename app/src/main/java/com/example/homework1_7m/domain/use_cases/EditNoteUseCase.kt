package com.example.homework1_7m.domain.use_cases

import com.example.homework1_7m.domain.model.Note
import com.example.homework1_7m.domain.repository.NoteRepository

class EditNoteUseCase(private val repo: NoteRepository) {

    fun editNote(note: Note) = repo.editNote(note.id, note)
}