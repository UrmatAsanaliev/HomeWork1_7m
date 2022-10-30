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
    private val list = ArrayList<Caps2>()


    override fun setupUI() {
        adapter = MainAdapter(this, arrayListOf())
        binding().rvKaps.adapter = adapter

        val listForSize = ArrayList<Int>()
        listForSize.add(2)

        list.add(Caps2(1, "New Era",
            "https://cdn1.ozone.ru/s3/multimedia-y/6063710134.jpg",
            "new Era", 2300, "20.20.2002", "20.20.2020", 2150, 2, listForSize))

        list.add(Caps2(1, "Live",
            "https://harbegon.ru/upload/5c0e236298e23-kepka-krasnaya-min.png",
            "Live for live", 2100, "20.20.2002", "20.20.2020", 2000, 2, listForSize))
        adapter.addData(list)


        binding().imgBack.setOnClickListener {
            findNavController().navigateUp()
        }


    }

    override fun onClickedItem(id: Int) {
    }


    override fun setupObserver() {
        lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.brand.collect {
                    when (it) {
                        is Resource.Success -> {
                            it.data?.let { brands ->  }
                        }
                        is Resource.Loading -> {
                        }
                        is Resource.Error -> {
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