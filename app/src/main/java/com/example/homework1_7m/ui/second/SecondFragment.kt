package com.example.homework1_7m.ui.second

import androidx.navigation.fragment.findNavController
import com.example.core.core.BaseFragment
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.FragmentSecondBinding

class SecondFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {

    override fun setupUI() {

        binding().materialButton.setOnClickListener {
            findNavController().navigate(R.id.thirdFragment)
        }
        
    }


}