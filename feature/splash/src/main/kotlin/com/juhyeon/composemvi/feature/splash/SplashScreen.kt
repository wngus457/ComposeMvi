package com.juhyeon.composemvi.feature.splash

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun SplashScreen(
    state: SplashContract.State
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("테스트 로딩")
    }
}