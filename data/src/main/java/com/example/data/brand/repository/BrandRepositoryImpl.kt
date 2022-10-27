package com.example.data.brand.repository

import com.example.core.Resource
import com.example.data.brand.data.BrandApi
import com.example.data.brand.model.toBrand
import com.example.data.brand.model.toBrandById
import com.example.domain.brand.model.Brand
import com.example.domain.brand.model.BrandById
import com.example.domain.brand.repo.BrandRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class BrandRepositoryImpl @Inject constructor(private val api: BrandApi): BrandRepository {

    override suspend fun getBrands(): Flow<Resource<List<Brand>>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.getBrand().brandList.map { it.toBrand() }
            emit(Resource.Success(list))
        } catch (e : HttpException) {
            emit(
                Resource.Error("Unknown error!!!"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error("Unknown Error!!!"))
        }
    }


    override suspend fun getBrandById(id: Int): Flow<Resource<BrandById>> = flow {
        try {
            emit(Resource.Loading())
            val brandDetails = api.getBrandById(id).toBrandById()
            emit(Resource.Success(brandDetails))
        } catch (e : HttpException) {
            emit(
                Resource.Error("Unknown error!!!"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error("Unknown error!!!"))
        }
    }
}