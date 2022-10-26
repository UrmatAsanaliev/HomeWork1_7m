package com.example.data.brand.data

import com.example.data.brand.model.BrandResponse
import retrofit2.http.GET

interface BrandApi {

    @GET("brand")
    suspend fun getBrand(): BrandResponse
}