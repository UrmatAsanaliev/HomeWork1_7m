package com.example.data.users.repo

import com.example.core.Resource
import com.example.data.brand.model.toBrand
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


    override suspend fun postTokenObtainPair(): Flow<Resource<TokenObtainPair>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.postTokenObtainPair().toTokenObtainPair()
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

    override suspend fun postTokenRefresh(): Flow<Resource<TokenRefresh>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.postTokenRefresh().toTokenRefresh()
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

    override suspend fun postLogin(): Flow<Resource<Login>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.postLogin().toLogin()
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

    override suspend fun postNewPassword(): Flow<Resource<SetNewPassword>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.postNewPassword().toSetNewPassword()
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

    override suspend fun patchUser(): Flow<Resource<User>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.patchUser().toUser()
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

    override suspend fun postRegister(): Flow<Resource<Registration>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.postRegister().toRegistration()
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

    override suspend fun postResetPasswordEmail(): Flow<Resource<ResetPasswordEmailRequest>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.postResetPasswordEmail().toResetPasswordEmailRequest()
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