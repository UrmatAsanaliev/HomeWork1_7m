package com.example.homework1_7m.ui.third

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.core.Resource
import com.example.core.core.BaseFragment
import com.example.domain.users.model.Registration
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.FragmentThirdBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ThirdFragment : BaseFragment<FragmentThirdBinding>(FragmentThirdBinding::inflate) {

    val viewModel: ThirdViewModel by viewModels()

    override fun setupUI() {
        if (arguments != null) {
            val name = requireArguments().getString("name")
            val phone = requireArguments().getString("phone")
            val pass = requireArguments().getString("pass")
            val confirm = requireArguments().getString("confirmPass")
        }

        binding().txtInter.setOnClickListener {
            findNavController().navigate(R.id.interFragment)
        }

        binding().signUp.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }


        binding().signUp.setOnClickListener {
            val name = binding().name.text.toString().trim()
            val phoneNumber = binding().phoneNumber.text.toString().trim()
            val pass = binding().pass.text.toString().trim()
            val confirmPass = binding().confirmPass.text.toString().trim()

            val registration = Registration(1, phoneNumber, name, pass, confirmPass)

            viewModel.getRegister(registration)

            lifecycleScope.launch {
                viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.register.collect {
                        when (it) {
                            is Resource.Success -> {
                                findNavController().navigate(R.id.mainFragment)
                            }
                            is Resource.Error -> {
                                Toast.makeText(requireContext(), it.message,
                                    Toast.LENGTH_SHORT).show()
                            }
                            is Resource.Loading -> {
                            }
                        }
                    }
                }
            }
        }
    }
}