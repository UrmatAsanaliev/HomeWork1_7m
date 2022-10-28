package com.example.domain.users.use_case

import com.example.domain.users.model.User
import com.example.domain.users.repository.UserRepository
import javax.inject.Inject

class PatchUserUseCase @Inject constructor(
    private val repo: UserRepository
) {

    suspend operator fun invoke(user: User) = repo.patchUser(user)
}