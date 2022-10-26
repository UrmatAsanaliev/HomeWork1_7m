package com.example.domain.brand.repo

import com.example.core.Resource
import com.example.domain.brand.model.Brand
import kotlinx.coroutines.flow.Flow

interface BrandRepository {

    suspend fun getBrands(): Flow<Resource<List<Brand>>>

}