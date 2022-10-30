package com.example.homework1_7m.ui.error

import androidx.navigation.fragment.findNavController
import com.example.core.core.BaseFragment
import com.example.homework1_7m.databinding.FragmentErrorBinding

class ErrorFragment : BaseFragment<FragmentErrorBinding>(FragmentErrorBinding::inflate) {


    override fun setupUI() {

        binding().imgBack.setOnClickListener {
            findNavController().navigateUp()
        }

    }

}