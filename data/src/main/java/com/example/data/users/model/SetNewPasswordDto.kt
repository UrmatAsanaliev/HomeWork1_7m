package com.example.data.users.model

import com.example.domain.users.model.SetNewPassword

data class SetNewPasswordDto(
    val password: String,
    val token: String,
    val uidb64 : String
)
fun SetNewPasswordDto.toSetNewPassword() : SetNewPassword {
    return SetNewPassword(
        password = password,
        token = token,
        uidb64 = uidb64
    )
}
