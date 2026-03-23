package com.juhyeon.composemvi.feature.home

import androidx.lifecycle.viewModelScope
import com.juhyeon.composemvi.core.mvi.BaseViewModel
import com.juhyeon.composemvi.domain.feature.test.post.DeletePostUseCase
import com.juhyeon.composemvi.domain.feature.test.post.GetLocalPostsUseCase
import com.juhyeon.composemvi.domain.feature.test.post.GetPostsUseCase
import com.juhyeon.composemvi.domain.feature.test.post.InsertPostUseCase
import com.juhyeon.composemvi.domain.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val deletePostUseCase: DeletePostUseCase,
    private val insertPostUseCase: InsertPostUseCase,
    private val getLocalPostsUseCase: GetLocalPostsUseCase,
    private val getPostsUseCase: GetPostsUseCase
) : BaseViewModel<HomeContract.Event, HomeContract.State, HomeContract.Effect>() {
    override fun initState() =  HomeContract.State(viewState = HomeContract.State.HomeViewState.Loading)

    override fun handleEvent(event: HomeContract.Event) {
        when (event) {
            else -> { }
        }
    }

    init {
        getPostsUseCase()
            .onSuccess {
                reducer.setState {
                    copy(
                        viewState = HomeContract.State.HomeViewState.Success(
                            posts = it,
                            localPosts = emptyList()
                        )
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    private fun deletePost() {

    }

    private fun insertPost() {

    }

    private fun getLocalPosts() {

    }
}