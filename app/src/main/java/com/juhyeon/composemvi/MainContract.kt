package com.juhyeon.composemvi

import com.juhyeon.composemvi.core.mvi.UiEffect
import com.juhyeon.composemvi.core.mvi.UiEvent
import com.juhyeon.composemvi.core.mvi.UiState

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