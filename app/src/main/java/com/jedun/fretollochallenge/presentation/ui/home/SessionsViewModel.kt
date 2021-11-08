package com.jedun.fretollochallenge.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jedun.fretollochallenge.domain.model.ApiResponse
import com.jedun.fretollochallenge.domain.model.SessionsItem
import com.jedun.fretollochallenge.domain.usecase.SessionListUseCase
import com.jedun.fretollochallenge.domain.util.Event
import com.jedun.fretollochallenge.presentation.model.Session
import com.jedun.fretollochallenge.presentation.model.ViewState
import com.jedun.fretollochallenge.presentation.ui.home.states.ExerciseState
import com.jedun.fretollochallenge.presentation.ui.home.states.SessionStateEvent
import com.jedun.fretollochallenge.presentation.ui.home.states.SessionViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SessionsViewModel @Inject constructor(
    private val sessionUseCase: SessionListUseCase
) : ViewModel() {

    private val _sessionStateObservable = MutableLiveData<SessionViewState>()
    val sessionViewStateObservable: LiveData<SessionViewState> = _sessionStateObservable

    private var sessionStateTemp: SessionViewState =
        SessionViewState(isLoading = true, viewState = ViewState.LOADING)

    private val _exerciseState: MutableLiveData<List<ExerciseState>> =
        MutableLiveData<List<ExerciseState>>()
    val exerciseState: LiveData<List<ExerciseState>> = _exerciseState


    fun getSessions() {

        _sessionStateObservable.value = SessionViewState(
            isLoading = true,
            viewState = if (sessionStateTemp.sessions.isNotEmpty()) ViewState.SUCCESS else ViewState.LOADING,
            sessions = sessionStateTemp.sessions
        )

        viewModelScope.launch {

            when (val sessionItems: ApiResponse<List<SessionsItem>> = sessionUseCase()) {

                is ApiResponse.Error -> {
                    _sessionStateObservable.value = SessionViewState(
                        isLoading = false,
                        error = sessionItems.errorMessage ?: "",
                        sessions = sessionStateTemp.sessions,
                        viewState = if (sessionStateTemp.sessions.isNotEmpty()) ViewState.SUCCESS else ViewState.ERROR,
                        snackError = Event(sessionItems.errorMessage ?: "")
                    )
                }

                is ApiResponse.Loading -> {
                    _sessionStateObservable.value = SessionViewState(
                        isLoading = true,
                        viewState = if (sessionStateTemp.sessions.isNotEmpty()) ViewState.SUCCESS else ViewState.LOADING
                    )
                }

                is ApiResponse.Success -> {
                    sessionStateTemp = SessionViewState(
                        isLoading = false,
                        sessions = sessionItems.response.map {
                            Session(it.name, it.practicedOnDate)
                        },
                        viewState = ViewState.SUCCESS
                    )

                    _exerciseState.value = sessionItems.response.map {
                        ExerciseState(it.name, it.exercises)
                    }
                    _sessionStateObservable.value = sessionStateTemp

                }
            }
        }
    }


    fun setEventState(event: SessionStateEvent) {
        when (event) {
            SessionStateEvent.GetSessions -> {
                getSessions()
            }
        }
    }
}