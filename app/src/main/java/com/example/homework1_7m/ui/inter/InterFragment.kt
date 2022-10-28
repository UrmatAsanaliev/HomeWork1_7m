package com.example.homework1_7m.ui.inter

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.core.Resource
import com.example.core.core.BaseFragment
import com.example.domain.users.model.Login
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.FragmentInterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class InterFragment : BaseFragment<FragmentInterBinding>(FragmentInterBinding::inflate) {

    private val viewModel: InterViewModel by viewModels()

    override fun setupUI() {
        binding().txtRegister.setOnClickListener{
            findNavController().navigate(R.id.secondFragment)
        }

        binding().txtReestablish.setOnClickListener {
            findNavController().navigate(R.id.restorePasswordFragment)
        }

        binding().materialButton.setOnClickListener {

            val phoneNumber = binding().phoneNumber.text.toString().trim()
            val pass = binding().pass.text.toString().trim()

            val login = Login(phoneNumber, pass, "1")

            viewModel.getLogin(login)


            lifecycleScope.launch {
                viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.login.collect {
                        when (it) {
                            is Resource.Success -> {
                                findNavController().navigate(R.id.mainFragment)
                            }
                            is Resource.Error -> {
                                Toast.makeText(requireContext(), "Unknown error!!!",
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