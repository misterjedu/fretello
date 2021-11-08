package com.jedun.fretollochallenge.domain.repository

import com.jedun.fretollochallenge.domain.model.ApiResponse
import com.jedun.fretollochallenge.domain.model.SessionsItem

interface SessionRepository {
    suspend fun getSessions(): ApiResponse<List<SessionsItem>>
}