package com.jedun.fretollochallenge.data.repository

import com.jedun.fretollochallenge.data.network.ApiService
import com.jedun.fretollochallenge.domain.mapper.DomainMapper
import com.jedun.fretollochallenge.domain.model.ApiResponse
import com.jedun.fretollochallenge.domain.model.SessionsItem
import com.jedun.fretollochallenge.domain.repository.SessionRepository
import retrofit2.HttpException
import java.io.IOException

class SessionRepositoryImpl(
    private val apiService: ApiService,
    var dtoMapper: DomainMapper

) : SessionRepository {

    override suspend fun getSessions(): ApiResponse<List<SessionsItem>> {
        return try {
            ApiResponse.Success(apiService.getSessions().map { dtoMapper.mapFromDto(it) })
        } catch (exception: Throwable) {

            when (exception) {
                is IOException -> {
                    ApiResponse.Error("Network Error. Check Internet connection")
                }
                is HttpException -> {
                    val errorResponse = convertErrorBody(exception)
                    ApiResponse.Error(exception.message())

                }
                else -> ApiResponse.Error("Error Unknown")

            }
        }
    }

    private fun convertErrorBody(throwable: HttpException): String? {
        return try {
            throwable.response()?.errorBody()?.string()
        } catch (exception: Exception) {
            "Unknown Error"
        }
    }

}