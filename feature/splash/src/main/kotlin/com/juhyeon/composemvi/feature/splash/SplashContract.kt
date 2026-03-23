package com.juhyeon.composemvi.feature.splash

import com.juhyeon.composemvi.core.mvi.UiEffect
import com.juhyeon.composemvi.core.mvi.UiEvent
import com.juhyeon.composemvi.core.mvi.UiState

interface SplashContract {
    sealed interface Event : UiEvent {

    }

    data class State(
        val viewState: SplashViewState
    ) : UiState {
        sealed interface SplashViewState {
            data object Loading : SplashViewState
            data object Success : SplashViewState
        }
    }

    sealed interface Effect : UiEffect {
        data object NavigateToHome : Effect
    }
}