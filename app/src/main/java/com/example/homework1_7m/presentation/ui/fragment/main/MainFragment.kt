package com.example.homework1_7m.presentation.ui.fragment.main

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.homework1_7m.R
import com.example.homework1_7m.core.BaseFragment
import com.example.homework1_7m.databinding.FragmentMainBinding
import com.example.homework1_7m.domain.model.Note
import com.example.homework1_7m.presentation.ui.fragment.main.adapter.NoteAdapter
import com.example.homework1_7m.utils.UIState
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val controller: NavController by lazy {
        val navHostFragment =
            requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navHostFragment.navController
    }
    private lateinit var adapter: NoteAdapter
    private val viewModel : MainViewModel by viewModels()

    override fun setupUI() {
        initAdapter()
        initViewModel()
        getNote()
    }

    private fun getNote() {
    }

    override fun setupObserver() {
        super.setupObserver()
        openAddNoteFragment()
    }

    private fun openAddNoteFragment() {
    }

    private fun initViewModel() {
        viewModel.getAllNotes()

        var e = Date()
        var i = 0
        binding().btnAddNewNote.setOnClickListener{
            i++
            viewModel.addNote(
                Note(
                    title = "title $i",
                    description = "desc $i",
                    creationDate = "$e"
                )
            )
        }


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
    }

    private fun initAdapter() {
        adapter = NoteAdapter()
        binding().rvNotes.adapter = adapter
    }

}