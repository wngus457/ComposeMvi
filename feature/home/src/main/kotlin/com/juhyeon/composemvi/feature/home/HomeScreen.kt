package com.juhyeon.composemvi.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun HomeScreen(
    state: HomeContract.State
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                if (state.viewState is HomeContract.State.HomeViewState.Success) {
                    items(state.viewState.posts) {
                        Column() {
                            Text(it.title)
                            Text(it.body)
                            HorizontalDivider()
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        state = HomeContract.State(
            viewState = HomeContract.State.HomeViewState.Success(
                posts = emptyList(),
                localPosts = emptyList()
            )
        )
    )
}