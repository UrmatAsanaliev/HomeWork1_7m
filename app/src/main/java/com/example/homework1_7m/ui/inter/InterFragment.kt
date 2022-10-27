package com.example.homework1_7m.ui.inter

import androidx.navigation.fragment.findNavController
import com.example.core.core.BaseFragment
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.FragmentInterBinding

class InterFragment : BaseFragment<FragmentInterBinding>(FragmentInterBinding::inflate) {

    override fun setupUI() {

        binding().register.setOnClickListener{
            findNavController().navigate(R.id.secondFragment)
        }

        binding().txtReestablish.setOnClickListener {
            findNavController().navigate(R.id.restorePasswordFragment)
        }

    }

}