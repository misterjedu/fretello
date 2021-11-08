package com.jedun.fretollochallenge.domain.model

data class SessionsItem(
    val exercises: List<Exercise>,
    val name: String,
    val practicedOnDate: String
)