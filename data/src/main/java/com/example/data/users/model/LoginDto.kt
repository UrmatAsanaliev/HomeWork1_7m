package com.example.data.users.model

import com.example.domain.users.model.Login

data class LoginDto(
    val email: String,
    val password: String,
    val token: String
)
fun LoginDto.toLogin(): Login {
    return Login(
        email = email,
        password = password,
        token = token
    )
}
