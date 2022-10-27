package com.example.homework1_7m.ui.product_details

import com.example.core.Resource
import com.example.core.core.BaseViewModel
import com.example.core.core.Dispatcher
import com.example.domain.brand.model.BrandById
import com.example.domain.brand.use_case.GetBrandByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val getBrandByIdUseCase: GetBrandByIdUseCase, appDispatcher: Dispatcher
): BaseViewModel(appDispatcher) {


    private val _brandDetails = MutableStateFlow<Resource<BrandById>>(Resource.Loading())
    val brandDetails = _brandDetails.asStateFlow()


    fun getBrandDetails(id: Int) {
        launchOnBack {
            getBrandByIdUseCase(id).collect{
                _brandDetails.value = it
            }
        }
    }


}