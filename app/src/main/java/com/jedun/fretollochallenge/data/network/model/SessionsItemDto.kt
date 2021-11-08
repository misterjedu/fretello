package com.jedun.fretollochallenge.data.network.model

import java.util.*

data class SessionsItemDto(
    val exercises: List<ExerciseDto>,
    val name: String,
    val practicedOnDate: Date
)