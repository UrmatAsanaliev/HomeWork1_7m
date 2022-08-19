package com.example.homework1_7m.presentation.ui.fragment.main

import com.example.homework1_7m.core.BaseViewModel
import com.example.homework1_7m.data.repo.NoteRepositoryImpl
import com.example.homework1_7m.domain.model.Note
import com.example.homework1_7m.domain.use_cases.AddNoteUseCase

class MainViewModel: BaseViewModel() {

    private val repo = NoteRepositoryImpl()
    private val addNoteUseCase= AddNoteUseCase(repo)

    fun addNote(note: Note){
        addNoteUseCase.addNote(note)
    }

}