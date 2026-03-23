package com.juhyeon.composemvi.feature.splash

import androidx.lifecycle.viewModelScope
import com.juhyeon.composemvi.core.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(

) : BaseViewModel<SplashContract.Event, SplashContract.State, SplashContract.Effect>() {
    override fun initState() = SplashContract.State(viewState = SplashContract.State.SplashViewState.Loading)

    override fun handleEvent(event: SplashContract.Event) {
        when (event) {
            else -> { }
        }
    }

    init {
        viewModelScope.launch {
            delay(2000)
            reducer.setEffect(SplashContract.Effect.NavigateToHome)
        }
    }
}