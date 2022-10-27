package com.example.homework1_7m.ui.main

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
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding:: inflate),
    MainAdapter.BrandItemListener {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter : MainAdapter


    override fun setupUI() {
        binding().txtWatchAllBestsellers.setOnClickListener {
            findNavController().navigate(
                R.id.bestsellersFragment)
        }
        adapter = MainAdapter(this, arrayListOf())
        binding().rvBestsellers.adapter = adapter

        binding().imgSort.setOnClickListener{
            findNavController().navigate(R.id.sortFragment)
        }
    }

    override fun onClickedItem(id: Int) {
        binding().txtWatchAllBestsellers.setOnClickListener {
            findNavController().navigate(
                R.id.bestsellersFragment,
                bundleOf(Const.PARAM_MOVIE_ID to id)
            )
        }
    }


    override fun setupObserver() {
        lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.brand.collect {
                    when (it) {
                        is Resource.Success -> {
                            binding().progressBar.visibility = View.GONE
                            it.data?.let { brands -> renderList(brands) }
                            binding().progressBar.visibility = View.VISIBLE
                        }
                        is Resource.Loading -> {
                            binding().progressBar.visibility = View.VISIBLE
                            binding().scrollView.visibility = View.GONE
                        }
                        is Resource.Error -> {
                            binding().progressBar.visibility = View.GONE
                            binding().scrollView.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }

    private fun renderList(brand: List<Brand>) {
        adapter.addData(brand)
    }
}