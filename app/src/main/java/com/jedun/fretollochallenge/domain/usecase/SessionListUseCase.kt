package com.jedun.fretollochallenge.domain.usecase

import com.jedun.fretollochallenge.domain.model.ApiResponse
import com.jedun.fretollochallenge.domain.model.SessionsItem
import com.jedun.fretollochallenge.domain.repository.SessionRepository
import javax.inject.Inject

class SessionListUseCase @Inject constructor(
    private val repository: SessionRepository,
) {

    suspend operator fun invoke(): ApiResponse<List<SessionsItem>> {
        val sessionsDto: ApiResponse<List<SessionsItem>> = repository.getSessions()

        return when (sessionsDto) {
            is ApiResponse.Error -> {
                ApiResponse.Error(sessionsDto.errorMessage)
            }
            is ApiResponse.Loading -> {
                ApiResponse.Loading()
            }
            is ApiResponse.Success -> {
                ApiResponse.Success(sessionsDto.response)
            }
        }
    }
}