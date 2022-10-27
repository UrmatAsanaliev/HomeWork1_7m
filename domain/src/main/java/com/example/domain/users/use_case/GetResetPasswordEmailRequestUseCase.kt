package com.example.domain.users.use_case

import com.example.core.Resource
import com.example.domain.users.model.ResetPasswordEmailRequest
import com.example.domain.users.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetResetPasswordEmailRequestUseCase @Inject constructor(
    private val repo: UserRepository
) {
    suspend operator fun invoke(token: String, uidb64: String) : Flow<Resource<ResetPasswordEmailRequest>> =
        repo.getResetPasswordEmailRequest(token, uidb64)
}