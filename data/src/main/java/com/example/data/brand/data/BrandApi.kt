package com.example.data.brand.data

import com.example.data.brand.model.BrandByIdDto
import com.example.data.brand.model.BrandResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BrandApi {

    @GET("brand")
    suspend fun getBrand(): BrandResponse

    @GET("/brand/{id}/")
    suspend fun getBrandById(@Path("id") id: Int) : BrandByIdDto
}