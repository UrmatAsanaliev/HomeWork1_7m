package com.example.data.users.data

import com.example.data.users.model.*
import com.example.domain.users.model.*
import retrofit2.Response
import retrofit2.http.*

interface UserApi {


    @POST("/users/api/token/")
    suspend fun postTokenObtainPair(
        @Body tokenObtainPair: TokenObtainPair
    ): TokenObtainPair


    @POST("/users/api/token/refresh/")
    suspend fun postTokenRefresh(
        @Body tokenRefresh: TokenRefresh
    ): TokenRefresh

    @POST("/users/login/")
    suspend fun postLogin(
        @Body login: Login
    ): Login

    @POST("/users/password-reset-complete/")
    suspend fun postNewPassword(
        @Body newPassword: SetNewPassword
    ) : SetNewPassword


    @GET("/users/password-reset/{uidb64}/{token}/")
    suspend fun getResetPasswordEmailRequest(
        @Path("token") token: String,
        @Path("uidb64") uidb64: String): ResetPasswordEmailRequestDto

    @GET("/users/profile/")
    suspend fun getUser(): UserDto

    @PATCH("/users/profile/")
    suspend fun patchUser(
        @Body user: User
    ) : User

    @POST("/users/register/")
    suspend fun postRegister(
        @Body registration: Registration
    ) : Registration

    @POST("/users/request-reset-email/")
    suspend fun postResetPasswordEmail(
        @Body resetPasswordEmailRequest: ResetPasswordEmailRequest
    ) : ResetPasswordEmailRequest

    @GET("/users/verify-email/")
    suspend fun getVerifyEmail(@Query("token") token: String)

}