package com.example.homework1_7m.ui.product_details

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.core.Const
import com.example.core.Resource
import com.example.core.core.BaseFragment
import com.example.domain.brand.model.BrandById
import com.example.homework1_7m.databinding.FragmentProductDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductDetailsFragment :
    BaseFragment<FragmentProductDetailsBinding>(FragmentProductDetailsBinding::inflate) {

    private val viewModel : ProductDetailsViewModel by viewModels()

    override fun setupUI() {
        arguments?.getInt(Const.PARAM_MOVIE_ID)?.let {
            viewModel.getBrandDetails(it)
        }
    }

    override fun setupObserver() {
        lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.brandDetails.collect {
                    when (it) {
                        is Resource.Success -> {
                            bindData(it.data)
                            binding().progressBar.visibility = View.GONE
                            binding().constContainer.visibility = View.VISIBLE
                        }
                        is Resource.Error -> {
                            binding().progressBar.visibility = View.GONE
                            Toast.makeText(requireContext(), "Unknown error!!!", Toast.LENGTH_SHORT).show()
                        }
                        is Resource.Loading -> {
                            binding().progressBar.visibility = View.VISIBLE
                            binding().constContainer.visibility = View.GONE
                        }
                    }
                }
            }
        }
    }

    private fun bindData(data: BrandById?) {
        if (data != null) {
            binding().txtName.text = data.name
            binding().txtDesc.text = data.description
            binding().txtPrice.text = data.price.toString()
            binding().S.text = data.size[0].toString()
            binding().L.text = data.size[1].toString()
            binding().M.text = data.size[2].toString()
            binding().XL.text = data.size[3].toString()
            binding().txtGolden.text = data.created
        } else {
            Toast.makeText(requireContext(), "Unknown error!!!", Toast.LENGTH_SHORT).show()
        }
    }

}