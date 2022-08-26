package com.example.homework1_7m.presentation.ui.fragment.main

import androidx.lifecycle.*
import com.example.homework1_7m.core.BaseViewModel
import com.example.homework1_7m.domain.model.Note
import com.example.homework1_7m.domain.use_cases.AddNoteUseCase
import com.example.homework1_7m.domain.use_cases.DeleteNoteUseCase
import com.example.homework1_7m.domain.use_cases.EditNoteUseCase
import com.example.homework1_7m.domain.use_cases.GetAllNotesUseCase
import com.example.homework1_7m.utils.Resource
import com.example.homework1_7m.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase
) : BaseViewModel() {

    private val _addNoteLd = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val addNoteLd = _addNoteLd.asStateFlow()

    private val _getAllNotesLD = MutableStateFlow<UIState<List<Note>>>(UIState.Loading())
    val getAllNotesLd = _getAllNotesLD.asStateFlow()

    private val _deleteNoteLd = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val deleteNotesLd = _deleteNoteLd.asStateFlow()

    private val _editNoteLd = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val editNotesLd = _editNoteLd.asStateFlow()

    fun addNote(note: Note)  {
        viewModelScope.launch(Dispatchers.IO) {
            addNoteUseCase.addNote(note).collect {
                when (it) {
                    is Resource.Error -> {
                        _addNoteLd.value = UIState.Error(it.message ?: "Unknown error!!")
                    }
                    is Resource.Loading -> {
                        _addNoteLd.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null)
                        _addNoteLd.value = UIState.Success(it.data)
                    }
                }
            }
        }
    }

    fun getAllNotes()  {
        viewModelScope.launch(Dispatchers.IO) {
            getAllNotesUseCase.getAllNotes().collect {
                when (it) {
                    is Resource.Error -> {
                        _getAllNotesLD.value = UIState.Error(it.message ?: "Unknown error!!")
                    }
                    is Resource.Loading -> {
                        _getAllNotesLD.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null)
                            _getAllNotesLD.value = UIState.Success(it.data)
                    }
                }
            }
        }
    }

    fun deleteNote(note: Note)  {
        viewModelScope.launch(Dispatchers.IO) {
            deleteNoteUseCase.deleteNote(note).collect {
                when (it) {
                    is Resource.Error -> {
                        _deleteNoteLd.value = UIState.Error(it.message ?: "Unknown error!!")
                    }
                    is Resource.Loading -> {
                        _deleteNoteLd.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null)
                            _deleteNoteLd.value = UIState.Success(it.data)
                    }
                }
            }
        }
    }

    fun editNote(id: Int, note: Note)  {
        viewModelScope.launch(Dispatchers.IO) {
            editNoteUseCase.editNote(id, note).collect {
                when (it) {
                    is Resource.Error -> {
                        _editNoteLd.value = UIState.Error(it.message ?: "Unknown error!!")
                    }
                    is Resource.Loading -> {
                        _editNoteLd.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null)
                            _editNoteLd.value = UIState.Success(it.data)
                    }
                }
            }
        }
    }
}