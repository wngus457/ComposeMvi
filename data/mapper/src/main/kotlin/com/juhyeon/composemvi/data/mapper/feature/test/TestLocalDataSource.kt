package com.juhyeon.composemvi.data.mapper.feature.test

import com.juhyeon.composemvi.data.mapper.feature.test.response.PostData
import kotlinx.coroutines.flow.Flow

interface TestLocalDataSource {
    suspend fun insertPost(param: PostData)

    suspend fun deletePost(userId: Int)

    fun getPosts(): Flow<List<PostData>>
}