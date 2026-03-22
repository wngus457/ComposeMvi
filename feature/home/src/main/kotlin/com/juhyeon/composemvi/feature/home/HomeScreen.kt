package com.juhyeon.composemvi.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun HomeScreen(
    state: HomeContract.State
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("테스트 홈")
    }
}