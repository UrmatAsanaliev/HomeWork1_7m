package com.example.homework1_7m.core

import com.example.homework1_7m.domain.model.Note
import com.example.homework1_7m.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown message!!"))
        }
    }
}