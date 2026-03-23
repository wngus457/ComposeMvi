package com.juhyeon.composemvi.feature.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.juhyeon.composemvi.shared.navigation.Home

@Composable
fun SplashRoute(
    navController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    val state = splashViewModel.stateFlow.collectAsState().value
    val handler = splashViewModel.eventHandler

    LaunchedEffect(true) {
        splashViewModel.effectFlow.collect { effect ->
            when (effect) {
                is SplashContract.Effect.NavigateToHome -> navController.navigate(route = Home) {
                    popUpTo(0) { inclusive = true }
                }
            }
        }
    }

    SplashScreen(
        state = state
    )
}