package com.example.domain.brand.repo

import com.example.core.Resource
import com.example.domain.brand.model.Brand
import com.example.domain.brand.model.BrandById
import kotlinx.coroutines.flow.Flow

interface BrandRepository {

    suspend fun getBrands(): Flow<Resource<List<Brand>>>

    suspend fun getBrandById(id: Int) : Flow<Resource<BrandById>>

}