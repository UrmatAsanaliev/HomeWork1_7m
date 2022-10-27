package com.example.domain.users.model

data class Registration(
    val id: Int,
    val email: String,
    val username: String,
    val password: String,
    val password2: String
)
