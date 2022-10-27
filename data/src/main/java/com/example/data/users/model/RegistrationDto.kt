package com.example.data.users.model

import com.example.domain.users.model.Registration

data class RegistrationDto(
    val id: Int,
    val email: String,
    val username: String,
    val password: String,
    val password2: String
)
fun RegistrationDto.toRegistration(): Registration {
    return Registration(
        id = id,
        email = email,
        username = username,
        password = password,
        password2 = password2
    )
}
