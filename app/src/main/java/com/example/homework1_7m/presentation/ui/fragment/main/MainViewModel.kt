package com.example.homework1_7m.presentation.ui.fragment.main

import androidx.lifecycle.*
import com.example.homework1_7m.core.BaseViewModel
import com.example.homework1_7m.domain.model.Note
import com.example.homework1_7m.domain.use_cases.AddNoteUseCase
import com.example.homework1_7m.domain.use_cases.GetAllNotesUseCase
import com.example.homework1_7m.utils.Resource
import com.example.homework1_7m.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val getAllNotesUseCase: GetAllNotesUseCase
) : BaseViewModel() {

    private val _addNoteLd = MutableLiveData<UIState<Unit>>()
    val addNoteLd = _addNoteLd as LiveData<UIState<Unit>>


    private val _getAllNotesLD = MutableLiveData<UIState<List<Note>>>()
    val getAllNotes = _getAllNotesLD as LiveData<UIState<List<Note>>>

    fun addNote(note: Note)  {
        viewModelScope.launch(Dispatchers.IO) {
            addNoteUseCase.addNote(note).map {
                when (it) {
                    is Resource.Error -> {
                        _addNoteLd.value = it.message?.let { it1 -> UIState.Error(it1) }
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
            getAllNotesUseCase.getAllNotes().map {
                when (it) {
                    is Resource.Error -> {
                        _getAllNotesLD.value = it.message?.let { it1 -> UIState.Error(it1) }
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
}