package com.example.homework1_7m.ui.get_code

import androidx.navigation.fragment.findNavController
import com.example.core.core.BaseFragment
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.FragmentGetCodeBinding


class GetCodeFragment : BaseFragment<FragmentGetCodeBinding>(FragmentGetCodeBinding::inflate) {


    override fun setupUI() {

        binding().btnRestorePass.setOnClickListener {
            findNavController().navigate(R.id.newPasswordCreateFragment)
        }
    }

}