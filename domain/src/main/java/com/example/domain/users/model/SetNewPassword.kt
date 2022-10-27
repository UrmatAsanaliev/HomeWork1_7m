package com.example.domain.users.model

data class SetNewPassword(
    val password: String,
    val token: String,
    val uidb64 : String
)
