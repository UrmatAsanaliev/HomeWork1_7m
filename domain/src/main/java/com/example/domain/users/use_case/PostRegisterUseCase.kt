package com.example.domain.users.use_case

import com.example.domain.users.repository.UserRepository
import javax.inject.Inject

class PostRegisterUseCase @Inject constructor(
    private val repo: UserRepository
) {

    suspend operator fun invoke() = repo.postRegister()
}