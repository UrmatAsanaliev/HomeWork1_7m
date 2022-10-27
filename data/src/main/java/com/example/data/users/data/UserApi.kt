package com.example.data.users.data

import com.example.data.users.model.*
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApi {


    @POST("/users/api/token/")
    suspend fun postTokenObtainPair(): TokenObtainPairDto


    @POST("/users/api/token/refresh/")
    suspend fun postTokenRefresh(): TokenRefreshDto

    @POST("/users/login/")
    suspend fun postLogin(): LoginDto

    @POST("/users/password-reset-complete/")
    suspend fun postNewPassword() : SetNewPasswordDto


    @GET("/users/password-reset/{uidb64}/{token}/")
    suspend fun getResetPasswordEmailRequest(
        @Path("token") token: String,
        @Path("uidb64") uidb64: String): ResetPasswordEmailRequestDto

    @GET("/users/profile/")
    suspend fun getUser(): UserDto

    @PATCH("/users/profile/")
    suspend fun patchUser() : UserDto

    @POST("/users/register/")
    suspend fun postRegister() : RegistrationDto

    @POST("/users/request-reset-email/")
    suspend fun postResetPasswordEmail() : ResetPasswordEmailRequestDto

    @GET("/users/verify-email/")
    suspend fun getVerifyEmail(@Query("token") token: String)

}