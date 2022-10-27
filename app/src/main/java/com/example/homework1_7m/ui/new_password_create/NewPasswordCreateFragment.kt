package com.example.homework1_7m.ui.new_password_create

import androidx.navigation.fragment.findNavController
import com.example.core.core.BaseFragment
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.FragmentNewPasswordCreateBinding


class NewPasswordCreateFragment : BaseFragment<FragmentNewPasswordCreateBinding>(FragmentNewPasswordCreateBinding::inflate) {


    override fun setupUI() {

        binding().btnRestorePass.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }
    }

}