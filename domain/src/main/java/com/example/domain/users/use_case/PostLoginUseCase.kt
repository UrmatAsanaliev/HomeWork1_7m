package com.example.domain.users.use_case

import com.example.domain.users.model.Login
import com.example.domain.users.repository.UserRepository
import javax.inject.Inject

class PostLoginUseCase @Inject constructor(
    private val repo: UserRepository
) {

    suspend operator fun invoke(login: Login) = repo.postLogin(login)
}