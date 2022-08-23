package com.example.homework1_7m.domain.use_cases

import com.example.homework1_7m.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(private val repo: NoteRepository) {

    fun getAllNotes() = repo.getAllNotes()
}