package com.example.data.users.model

import com.example.domain.users.model.User

data class UserDto(
    val first_name: String,
    val last_name: String,
    val username: String,
    val email: String,
    val avatar: String,
    val phone: String,
    val city: String
)
fun UserDto.toUser() : User {
    return User(
        first_name = first_name,
        last_name = last_name,
        username = username,
        email = email,
        avatar = avatar,
        phone = phone,
        city = city
    )
}
