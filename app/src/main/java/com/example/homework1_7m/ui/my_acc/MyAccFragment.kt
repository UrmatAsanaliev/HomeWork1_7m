package com.example.homework1_7m.ui.my_acc

import androidx.navigation.fragment.findNavController
import com.example.core.core.BaseFragment
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.FragmentMyAccBinding


class MyAccFragment : BaseFragment<FragmentMyAccBinding>(FragmentMyAccBinding::inflate) {


    override fun setupUI() {
        binding().profile.setOnClickListener{
            findNavController().navigate(R.id.profileFragment)
        }
        binding().order.setOnClickListener{
            findNavController().navigate(R.id.myOrdersFragment)
        }
    }

}