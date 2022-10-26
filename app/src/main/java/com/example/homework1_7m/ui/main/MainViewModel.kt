package com.example.homework1_7m.ui.main

import com.example.core.Resource
import com.example.core.core.BaseViewModel
import com.example.core.core.Dispatcher
import com.example.domain.brand.model.Brand
import com.example.domain.brand.use_case.GetBrandsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getBrandsUseCase: GetBrandsUseCase, appDispatcher: Dispatcher
): BaseViewModel(appDispatcher) {

    private val _brand = MutableStateFlow<Resource<List<Brand>>>(Resource.Loading())
    val brand = _brand.asStateFlow()

    init {
        getBrands()
    }

    private fun getBrands() {
        launchOnBack {
            getBrandsUseCase().collect {
                _brand.value = it
            }
        }
    }
}