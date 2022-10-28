package com.example.homework1_7m.ui.first

import androidx.navigation.fragment.findNavController
import com.example.core.core.BaseFragment
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.FragmentFirstBinding

class FirstFragment : BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {


    override fun setupUI() {
        binding().signUp.setOnClickListener {
            findNavController().navigate(R.id.interFragment)
        }

        binding().register.setOnClickListener {
            findNavController().navigate(R.id.thirdFragment)
        }


    }

}