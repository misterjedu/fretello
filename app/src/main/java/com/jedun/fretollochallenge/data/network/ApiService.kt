package com.jedun.fretollochallenge.data.network

import com.jedun.fretollochallenge.data.network.model.SessionsItemDto
import retrofit2.http.GET

interface ApiService {

    @GET("data/sessions.json")
    suspend fun getSessions(): List<SessionsItemDto>

}