package com.example.data.caps.data

import com.example.data.caps.model.CapsDetailsDto
import com.example.data.caps.model.CapsResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface CapsApi {

    @GET("caps")
    suspend fun getCaps() : CapsResponse

    @GET("/caps/{id}/")
    suspend fun getCapsDetails(@Path("id") id: Int) : CapsDetailsDto
}