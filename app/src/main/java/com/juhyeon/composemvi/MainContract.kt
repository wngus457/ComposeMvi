package com.juhyeon.composemvi

import UiEffect
import UiEvent
import UiState

interface MainContract {

    sealed interface Event : UiEvent

    data class State(
        val mainState: MainState
    ) : UiState {

        sealed interface MainState {
            object Loading : MainState
            object Success : MainState
        }
    }

    sealed interface Effect : UiEffect
}