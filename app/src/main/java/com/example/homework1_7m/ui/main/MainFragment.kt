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
import com.example.domain.caps.model.Caps
import com.example.domain.caps.model.Caps2
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding:: inflate),
    MainAdapter.BrandItemListener {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter : MainAdapter
    private val list = ArrayList<Caps2>()


    override fun setupUI() {
        binding().imgForthBrand.setOnClickListener {
            findNavController().navigate(R.id.errorFragment)
        }

        binding().imgSecondBrand.setOnClickListener {
            findNavController().navigate(R.id.errorFragment)
        }

        binding().imgThirdBrand.setOnClickListener {
            findNavController().navigate(R.id.errorFragment)
        }

        binding().imgFirstBrand.setOnClickListener {
            findNavController().navigate(R.id.errorFragment)
        }


        binding().cont.setOnClickListener {
            findNavController().navigate(R.id.errorFragment)
        }

        binding().container2.setOnClickListener {
            findNavController().navigate(R.id.errorFragment)
        }



        binding().txtWatchAllBestsellers.setOnClickListener {
            findNavController().navigate(
                R.id.bestsellersFragment)
        }
        adapter = MainAdapter(this, arrayListOf())
        binding().rvBestsellers.adapter = adapter
        binding().rvStocks.adapter = adapter

        binding().imgSort.setOnClickListener{
            findNavController().navigate(R.id.sortFragment)
        }


        val listForSize = ArrayList<Int>()
        listForSize.add(2)

        list.add(Caps2(1, "New Era",
            "https://cdn1.ozone.ru/s3/multimedia-y/6063710134.jpg",
            "new Era", 2300, "20.20.2002", "20.20.2020", 2350, 2, listForSize))
        adapter.addData(list)

    }

    override fun onClickedItem(id: Int) {
            findNavController().navigate(R.id.productDetailsFragment,
                bundleOf(Const.PARAM_MOVIE_ID to id))
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

    private fun renderList(brand: List<Caps>) {
        adapter.addData(list)
    }
}