package com.jedun.fretollochallenge.presentation.ui.exerciselist.states

import com.jedun.fretollochallenge.domain.util.Event
import com.jedun.fretollochallenge.presentation.model.CompleteExercise
import com.jedun.fretollochallenge.presentation.model.ViewState

data class SessionViewState(
    val isLoading: Boolean = false,
    var sessions: List<CompleteExercise> = listOf(),
    val error: String = "",
    val viewState: ViewState,
    val snackError: Event<String> = Event("")
)
