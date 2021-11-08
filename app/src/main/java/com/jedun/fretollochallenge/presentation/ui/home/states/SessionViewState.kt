package com.jedun.fretollochallenge.presentation.ui.home.states

import com.jedun.fretollochallenge.domain.util.Event
import com.jedun.fretollochallenge.presentation.model.Session
import com.jedun.fretollochallenge.presentation.model.ViewState

data class SessionViewState(
    val isLoading: Boolean = false,
    var sessions: List<Session> = listOf(),
    val error: String = "",
    val viewState: ViewState,
    val snackError: Event<String> = Event("")
)
