package com.jedun.fretollochallenge.presentation.ui.exerciselist.states

import com.jedun.fretollochallenge.domain.model.Exercise

data class ExerciseState(
    var exerciseName: String,
    var exerciseList: List<Exercise>
)