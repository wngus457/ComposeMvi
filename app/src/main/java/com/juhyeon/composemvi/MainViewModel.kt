package com.juhyeon.composemvi

import com.juhyeon.composemvi.core.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

) : BaseViewModel<MainContract.Event, MainContract.State, MainContract.Effect>() {

    override fun initState() = MainContract.State(
        mainState = MainContract.State.MainState.Loading
    )

    override fun handleEvent(event: MainContract.Event) {

    }
}