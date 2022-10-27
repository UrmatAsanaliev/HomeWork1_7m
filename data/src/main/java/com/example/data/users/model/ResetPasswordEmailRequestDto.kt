package com.example.data.users.model

import com.example.domain.users.model.ResetPasswordEmailRequest

data class ResetPasswordEmailRequestDto(
    val email: String,
    val redirect_url: String
)
fun ResetPasswordEmailRequestDto.toResetPasswordEmailRequest() : ResetPasswordEmailRequest {
    return ResetPasswordEmailRequest(
        email = email,
        redirect_url = redirect_url
    )
}
