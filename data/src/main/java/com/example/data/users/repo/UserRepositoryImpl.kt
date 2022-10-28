package com.example.data.users.repo

import com.example.core.Resource
import com.example.data.users.data.UserApi
import com.example.data.users.model.*
import com.example.domain.users.model.*
import com.example.domain.users.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi
) : UserRepository {

    override suspend fun postTokenObtainPair(tokenObtainPair: TokenObtainPair): Flow<Resource<TokenObtainPair>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.postTokenObtainPair(tokenObtainPair)
            emit(Resource.Success(list))
        } catch (e : HttpException) {
            emit(
                Resource.Error("Unknown error!!!"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error("Unknown Error!!!"))
        }
    }

    override suspend fun postTokenRefresh(tokenRefresh: TokenRefresh): Flow<Resource<TokenRefresh>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.postTokenRefresh(tokenRefresh)
            emit(Resource.Success(list))
        } catch (e : HttpException) {
            emit(
                Resource.Error("Unknown error!!!"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error("Unknown Error!!!"))
        }
    }

    override suspend fun postLogin(login: Login): Flow<Resource<Login>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.postLogin(login)
            emit(Resource.Success(list))
        } catch (e : HttpException) {
            emit(
                Resource.Error("Unknown error!!!"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error("Unknown Error!!!"))
        }
    }

    override suspend fun postNewPassword(newPassword: SetNewPassword): Flow<Resource<SetNewPassword>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.postNewPassword(newPassword)
            emit(Resource.Success(list))
        } catch (e : HttpException) {
            emit(
                Resource.Error("Unknown error!!!"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error("Unknown Error!!!"))
        }
    }

    override suspend fun getResetPasswordEmailRequest(
        token: String,
        uidb64: String
    ): Flow<Resource<ResetPasswordEmailRequest>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.getResetPasswordEmailRequest(token, uidb64).toResetPasswordEmailRequest()
            emit(Resource.Success(list))
        } catch (e : HttpException) {
            emit(
                Resource.Error("Unknown error!!!"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error("Unknown Error!!!"))
        }
    }

    override suspend fun getUser(): Flow<Resource<User>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.getUser().toUser()
            emit(Resource.Success(list))
        } catch (e : HttpException) {
            emit(
                Resource.Error("Unknown error!!!"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error("Unknown Error!!!"))
        }
    }

    override suspend fun patchUser(user: User): Flow<Resource<User>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.patchUser(user)
            emit(Resource.Success(list))
        } catch (e : HttpException) {
            emit(
                Resource.Error("Unknown error!!!"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error("Unknown Error!!!"))
        }
    }

    override suspend fun postRegister(registration: Registration): Flow<Resource<Registration>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.postRegister(registration)
            emit(Resource.Success(list))
        } catch (e : HttpException) {
            emit(
                Resource.Error("Unknown error!!!")
            )
        } catch (e: IOException) {
            emit(Resource.Error("Произошла ошибка!!!")
            )
        }
    }

    override suspend fun postResetPasswordEmail(resetPasswordEmailRequest: ResetPasswordEmailRequest): Flow<Resource<ResetPasswordEmailRequest>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.postResetPasswordEmail(resetPasswordEmailRequest)
            emit(Resource.Success(list))
        } catch (e : HttpException) {
            emit(
                Resource.Error("Unknown error!!!"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error("Unknown Error!!!"))
        }
    }

//    override suspend fun getVerifyEmail(token: String) = flow {
//        TODO("Not yet implemented")
//    }
}