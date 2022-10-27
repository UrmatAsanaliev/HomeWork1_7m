package com.example.data.users.model

import com.example.domain.users.model.TokenRefresh

data class TokenRefreshDto(
    val refresh : String,
    val access : String
)
fun TokenRefreshDto.toTokenRefresh() : TokenRefresh {
    return TokenRefresh(
        refresh = refresh,
        access = access
    )
}
