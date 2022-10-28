package com.example.homework1_7m.ui.second

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.core.Const
import com.example.core.core.BaseFragment
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {

    override fun setupUI() {

        binding().materialButton.setOnClickListener {
            val name = binding().name.text.toString().trim()
            val phoneNumber = binding().phoneNumber.text.toString().trim()
            val password = binding().pass.text.toString().trim()
            val confirmPassword = binding().confirmPass.text.toString().trim()

            val bundle = Bundle()
            bundle.putString("name", name)
            bundle.putString("phone", phoneNumber)
            bundle.putString("pass", password)
            bundle.putString("confirmPass", confirmPassword)

            findNavController().navigate(R.id.thirdFragment, bundle)
        }
        
    }


}