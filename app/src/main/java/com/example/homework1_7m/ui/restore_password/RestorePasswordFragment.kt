package com.example.homework1_7m.ui.restore_password

import androidx.navigation.fragment.findNavController
import com.example.core.core.BaseFragment
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.FragmentRestorePasswordBinding


class RestorePasswordFragment : BaseFragment<FragmentRestorePasswordBinding>(FragmentRestorePasswordBinding::inflate) {


    override fun setupUI() {

        binding().btnSend.setOnClickListener {
            findNavController().navigate(R.id.getCodeFragment)
        }
    }
}