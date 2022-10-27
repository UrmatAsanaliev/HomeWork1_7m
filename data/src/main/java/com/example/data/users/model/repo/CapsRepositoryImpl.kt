package com.example.data.users.model.repo

import com.example.core.Resource
import com.example.data.caps.data.CapsApi
import com.example.data.caps.model.toCaps
import com.example.data.caps.model.toCapsDetails
import com.example.domain.caps.model.Caps
import com.example.domain.caps.model.CapsDetails
import com.example.domain.caps.repository.CapsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CapsRepositoryImpl @Inject constructor(private val api: CapsApi) : CapsRepository {

    override suspend fun getCaps(): Flow<Resource<List<Caps>>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.getCaps().caps.map { it.toCaps() }
            emit(Resource.Success(list))
        } catch (e: HttpException) {
            emit(
                Resource.Error("Unknown error!!!"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error("Unknown error!!!"))
        }
    }


    override suspend fun getCapsDetails(id: Int): Flow<Resource<CapsDetails>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.getCapsDetails(id).toCapsDetails()
            emit(Resource.Success(list))
        } catch (E : HttpException) {
            emit (
                Resource.Error("Unknown error!!!"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error("Unknown error!!!"))
        }
    }
}