package com.example.homework1_7m.presentation.ui.fragment.main

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.homework1_7m.R
import com.example.homework1_7m.core.BaseFragment
import com.example.homework1_7m.databinding.FragmentMainBinding
import com.example.homework1_7m.domain.model.Note
import com.example.homework1_7m.presentation.ui.fragment.main.adapter.NoteAdapter


class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private lateinit var viewModel: MainViewModel
    private val controller: NavController by lazy {
        val navHostFragment =
            requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navHostFragment.navController
    }
    private lateinit var adapter: NoteAdapter

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
        binding().btnAddNewNote.setOnClickListener{
            controller.navigate(R.id.secondFragment)
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    private fun initAdapter() {
        adapter = NoteAdapter()
        binding().rvNotes.adapter = adapter
    }

}