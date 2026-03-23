package com.juhyeon.composemvi.domain.feature.test

import com.juhyeon.composemvi.domain.Result
import com.juhyeon.composemvi.domain.feature.test.post.Post
import kotlinx.coroutines.flow.Flow

interface TestRepository {
    fun getPosts(): Flow<Result<List<Post>>>

    suspend fun insertPost(param: Post)

    suspend fun deletePost(userId: Int)

    fun getLocalPosts(): Flow<Result<List<Post>>>
}