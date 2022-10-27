package com.example.domain.caps.use_case

import com.example.domain.caps.repository.CapsRepository
import javax.inject.Inject

class GetCapsUseCase @Inject constructor(
    private val repository : CapsRepository
) {

    suspend operator fun invoke() = repository.getCaps()
}