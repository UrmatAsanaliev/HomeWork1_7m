package com.example.domain.brand.use_case

import com.example.domain.brand.repo.BrandRepository
import javax.inject.Inject

class GetBrandsUseCase @Inject constructor(
    private val repository: BrandRepository
) {
    suspend operator fun invoke() = repository.getBrands()

}