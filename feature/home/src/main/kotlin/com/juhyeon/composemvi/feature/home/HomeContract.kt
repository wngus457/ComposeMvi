package com.juhyeon.composemvi.feature.home

import com.juhyeon.composemvi.core.mvi.UiEffect
import com.juhyeon.composemvi.core.mvi.UiEvent
import com.juhyeon.composemvi.core.mvi.UiState
import com.juhyeon.composemvi.domain.feature.test.post.Post

interface HomeContract {
    sealed interface Event : UiEvent {

    }

    data class State(
        val viewState: HomeViewState
    ) : UiState {
        sealed interface HomeViewState {
            data object Loading : HomeViewState
            data class Success(
                val posts: List<Post>,
                val localPosts: List<Post>
            ) : HomeViewState
        }
    }

    sealed interface Effect : UiEffect {

    }
}