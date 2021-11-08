package com.jedun.fretollochallenge.presentation.mapper

import com.jedun.fretollochallenge.domain.model.SessionsItem
import com.jedun.fretollochallenge.presentation.model.CompleteExercise
import com.jedun.fretollochallenge.presentation.ui.util.UiMapper
import javax.inject.Inject

class SessionListMapper @Inject constructor() : UiMapper<SessionsItem, CompleteExercise> {
    override fun mapFromDto(dto: SessionsItem): CompleteExercise {

        var exercisesName = ""

        dto.exercises.reversed().forEach {
            exercisesName += "${it.name} : Practised at ${it.practicedAtBpm} BPM \n\n"
        }

        return CompleteExercise(
            dto.name,
            dto.practicedOnDate,
            exercisesName
        )
    }
}