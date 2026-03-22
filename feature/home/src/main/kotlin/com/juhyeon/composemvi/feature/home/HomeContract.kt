package com.juhyeon.composemvi.feature.home

import com.juhyeon.composemvi.core.mvi.UiEffect
import com.juhyeon.composemvi.core.mvi.UiEvent
import com.juhyeon.composemvi.core.mvi.UiState

interface HomeContract {
    sealed interface Event : UiEvent {

    }

    data class State(
        val viewState: HomeViewState
    ) : UiState {
        sealed interface HomeViewState {
            data object Loading : HomeViewState
            data object Success : HomeViewState
        }
    }

    sealed interface Effect : UiEffect {

    }
}