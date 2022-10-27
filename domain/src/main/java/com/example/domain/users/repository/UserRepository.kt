package com.example.domain.users.repository

import com.example.core.Resource
import com.example.domain.users.model.*
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun postTokenObtainPair() : Flow<Resource<TokenObtainPair>>

    suspend fun postTokenRefresh(): Flow<Resource<TokenRefresh>>

    suspend fun postLogin() : Flow<Resource<Login>>

    suspend fun postNewPassword() : Flow<Resource<SetNewPassword>>

    suspend fun getResetPasswordEmailRequest(token: String, uidb64: String)
    : Flow<Resource<ResetPasswordEmailRequest>>

    suspend fun getUser() : Flow<Resource<User>>

    suspend fun patchUser() : Flow<Resource<User>>

    suspend fun postRegister() : Flow<Resource<Registration>>

    suspend fun postResetPasswordEmail() : Flow<Resource<ResetPasswordEmailRequest>>

 //   suspend fun getVerifyEmail(token: String): Flow<Resource<Unit>>
}