package com.example.homework1_7m.presentation.ui.fragment.second

import android.content.Context
import android.widget.Toast
import com.example.homework1_7m.core.BaseFragment
import com.example.homework1_7m.databinding.FragmentSecondBinding

class SecondFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate){

    override fun setupUI() {
        Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).show()
    }

}