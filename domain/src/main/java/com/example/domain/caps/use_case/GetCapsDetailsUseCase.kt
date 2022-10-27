package com.example.domain.caps.use_case

import com.example.core.Resource
import com.example.domain.caps.model.CapsDetails
import com.example.domain.caps.repository.CapsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCapsDetailsUseCase @Inject constructor(
    private val repository : CapsRepository
) {

    suspend operator fun invoke(id: Int) : Flow<Resource<CapsDetails>> =
        repository.getCapsDetails(id)
}