package com.jedun.fretollochallenge.presentation.mapper

import com.jedun.fretollochallenge.domain.model.SessionsItem
import com.jedun.fretollochallenge.presentation.model.CompleteExercise
import com.jedun.fretollochallenge.presentation.model.ImageExercise
import com.jedun.fretollochallenge.presentation.ui.util.UiMapper
import javax.inject.Inject

class SessionListMapper @Inject constructor() : UiMapper<SessionsItem, CompleteExercise> {
    override fun mapFromDto(dto: SessionsItem): CompleteExercise {
        return CompleteExercise(
            dto.name,
            dto.practicedOnDate,
            dto.exercises.map {
                ImageExercise(
                    "${it.name} \n\n Practiced at : ${it.practicedAtBpm} BPM",
                    "http://codingtest.fretello.com:3000/img/${it.exerciseId}.png",
                )
            }
        )
    }
}