package com.example.domain.brand.use_case

import com.example.core.Resource
import com.example.domain.brand.model.BrandById
import com.example.domain.brand.repo.BrandRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBrandByIdUseCase @Inject constructor(
    private val repository: BrandRepository
) {

    suspend operator fun invoke(id: Int): Flow<Resource<BrandById>> =
        repository.getBrandById(id)
}