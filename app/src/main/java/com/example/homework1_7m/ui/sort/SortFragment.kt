package com.example.homework1_7m.ui.sort

import androidx.navigation.fragment.findNavController
import com.example.core.core.BaseFragment
import com.example.homework1_7m.databinding.FragmentSortBinding

class SortFragment : BaseFragment<FragmentSortBinding>(FragmentSortBinding::inflate) {

    override fun setupUI() {

        binding().imgBack.setOnClickListener {
            findNavController().navigateUp()
        }

    }

}