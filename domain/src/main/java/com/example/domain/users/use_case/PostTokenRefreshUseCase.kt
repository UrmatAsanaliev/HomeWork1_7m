package com.example.domain.users.use_case

import com.example.domain.users.model.TokenRefresh
import com.example.domain.users.repository.UserRepository
import javax.inject.Inject

class PostTokenRefreshUseCase @Inject constructor(
    private val repo: UserRepository
) {

    suspend operator fun invoke(tokenRefresh: TokenRefresh) =
        repo.postTokenRefresh(tokenRefresh)
}