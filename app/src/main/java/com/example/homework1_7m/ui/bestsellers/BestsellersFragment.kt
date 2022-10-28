package com.example.homework1_7m.ui.bestsellers

import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.core.Const
import com.example.core.Resource
import com.example.core.core.BaseFragment
import com.example.domain.brand.model.Brand
import com.example.domain.caps.model.Caps
import com.example.domain.caps.model.Caps2
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.FragmentBestsellersBinding
import com.example.homework1_7m.ui.main.MainAdapter
import com.example.homework1_7m.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BestsellersFragment : BaseFragment<FragmentBestsellersBinding>(FragmentBestsellersBinding::inflate),MainAdapter.BrandItemListener {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter : MainAdapter


    override fun setupUI() {
        adapter = MainAdapter(this, arrayListOf())
        binding().rvKaps.adapter = adapter

    }

    override fun onClickedItem(id: Int) {
    }


    override fun setupObserver() {
        lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.brand.collect {
                    when (it) {
                        is Resource.Success -> {
                            binding().progressBar.visibility = View.GONE
                            it.data?.let { brands ->  }
                            binding().progressBar.visibility = View.VISIBLE
                        }
                        is Resource.Loading -> {
                            binding().progressBar.visibility = View.VISIBLE
                        }
                        is Resource.Error -> {
                            binding().progressBar.visibility = View.GONE
                        }
                    }
                }
            }
        }
    }

    private fun renderList(brand: List<Caps2>) {
        adapter.addData(brand)
    }
}