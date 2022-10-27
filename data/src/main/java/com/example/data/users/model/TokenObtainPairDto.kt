package com.example.data.users.model

import com.example.domain.users.model.TokenObtainPair

data class TokenObtainPairDto(
    val email: String,
    val password: String
)
fun TokenObtainPairDto.toTokenObtainPair() : TokenObtainPair {
    return TokenObtainPair(
        email = email,
        password = password
    )
}
