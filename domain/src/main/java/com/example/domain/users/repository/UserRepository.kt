package com.example.domain.users.repository

import com.example.core.Resource
import com.example.domain.users.model.*
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun postTokenObtainPair(tokenObtainPair: TokenObtainPair) : Flow<Resource<TokenObtainPair>>

    suspend fun postTokenRefresh(tokenRefresh: TokenRefresh): Flow<Resource<TokenRefresh>>

    suspend fun postLogin(login: Login) : Flow<Resource<Login>>

    suspend fun postNewPassword(newPassword: SetNewPassword) : Flow<Resource<SetNewPassword>>

    suspend fun getResetPasswordEmailRequest(token: String, uidb64: String)
    : Flow<Resource<ResetPasswordEmailRequest>>

    suspend fun getUser() : Flow<Resource<User>>

    suspend fun patchUser(user: User) : Flow<Resource<User>>

    suspend fun postRegister(registration: Registration) : Flow<Resource<Registration>>

    suspend fun postResetPasswordEmail(resetPasswordEmailRequest: ResetPasswordEmailRequest) : Flow<Resource<ResetPasswordEmailRequest>>

 //   suspend fun getVerifyEmail(token: String): Flow<Resource<Unit>>
}