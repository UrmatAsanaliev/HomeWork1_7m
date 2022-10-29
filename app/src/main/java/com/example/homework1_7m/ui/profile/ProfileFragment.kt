package com.example.homework1_7m.ui.profile

import androidx.navigation.fragment.findNavController
import com.example.core.core.BaseFragment
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.FragmentProfileBinding


class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {


    override fun setupUI() {
        binding().button.setOnClickListener{
            findNavController().navigate(R.id.updateProfileFragment)
        }
    }

}