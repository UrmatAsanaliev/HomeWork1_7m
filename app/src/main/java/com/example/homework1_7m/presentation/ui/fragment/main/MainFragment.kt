package com.example.homework1_7m.presentation.ui.fragment.main

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.core.core.BaseFragment
import com.example.core.core.UIState
import com.example.domain.domain.model.Note
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.FragmentMainBinding
import com.example.homework1_7m.presentation.ui.fragment.main.adapter.NoteAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate),
NoteAdapter.OnClick {

    private lateinit var adapter: NoteAdapter
    private val viewModel by viewModels<MainViewModel>()

    override fun setupUI() {
        initAdapter()
        initViewModel()
    }

    override fun setupObserver() {
        super.setupObserver()
        openAddNoteFragment()
        getNote()
    }

    private fun getNote() {
        val bundle = arguments
        val edTitle = bundle?.getString("edTitle")
        val edDesc = bundle?.getString("edDesc")

        if (edTitle != null || edDesc != null) {
            val e = Date()
            viewModel.addNote(
                Note(
                    title = edTitle,
                    description = edDesc,
                    creationDate = "$e"
                )
            )
        }
    }

    private fun openAddNoteFragment() {
        binding().btnAddNewNote.setOnClickListener{
            findNavController().navigate(R.id.secondFragment)
        }
    }

    private fun initViewModel() {
        viewModel.getAllNotes()

        viewModel.addNoteLd.subscribe {
            when (it) {
                is UIState.Error -> {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }
                is UIState.Loading -> {
//                    TODO("show progress bar")
                }
                is UIState.Success -> {
                    viewModel.getAllNotes()
                }
            }
        }

        viewModel.getAllNotesLd.subscribe {
            when (it) {
                is UIState.Error -> {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }
                is UIState.Loading -> {
//                    TODO("show progress bar")
                }
                is UIState.Success -> {
                    adapter.setList(it.data)
                }
            }
        }

        viewModel.editNotesLd.subscribe {
            when (it) {
                is UIState.Error -> {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }
                is UIState.Loading -> {
//                    TODO("show progress bar")
                }
                is UIState.Success -> {
                    // adapter.setList()
                }
            }
        }
    }

    private fun initAdapter() {8
        adapter = NoteAdapter(this)
        binding().rvNotes.adapter = adapter
    }



    private fun deleteNote(note: Note) {
        viewModel.getAllNotes()

        viewModel.deleteNotesLd.subscribe {
            when (it) {
                is UIState.Error -> {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }
                is UIState.Loading -> {
//                    TODO("show progress bar")
                }
                is UIState.Success -> {
                    // adapter.setList()
                    viewModel.deleteNote(note)
                }
            }
        }
    }

    override fun clickDelete(position: Int) {
    }


}