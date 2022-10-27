package com.example.domain.caps.repository

import com.example.core.Resource
import com.example.domain.caps.model.Caps
import com.example.domain.caps.model.CapsDetails
import kotlinx.coroutines.flow.Flow

interface CapsRepository {

    suspend fun getCaps(): Flow<Resource<List<Caps>>>

    suspend fun getCapsDetails(id: Int) : Flow<Resource<CapsDetails>>
}