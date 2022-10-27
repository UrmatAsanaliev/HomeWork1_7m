package com.example.domain.users.model

data class ResetPasswordEmailRequest(
    val email: String,
    val redirect_url: String
)
