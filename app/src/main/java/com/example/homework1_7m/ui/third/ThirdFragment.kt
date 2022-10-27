package com.example.homework1_7m.ui.third

import androidx.navigation.fragment.findNavController
import com.example.core.core.BaseFragment
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.FragmentThirdBinding


class ThirdFragment : BaseFragment<FragmentThirdBinding>(FragmentThirdBinding::inflate) {

    override fun setupUI() {

        binding().txtInter.setOnClickListener {
            findNavController().navigate(R.id.interFragment)
        }

        binding().signUp.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }
    }

}