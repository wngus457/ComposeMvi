package com.juhyeon.composemvi

import MviReducer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

) : ViewModel() {

    private val reducer = MviReducer<MainContract.Event, MainContract.State, MainContract.Effect>(
        viewModelScope = viewModelScope,
        initialState = initState(),
        handleEvent = ::handleEvent
    )

    private fun initState() = MainContract.State(
        mainState = MainContract.State.MainState.Loading
    )

    private fun handleEvent(event: MainContract.Event) {

    }
}