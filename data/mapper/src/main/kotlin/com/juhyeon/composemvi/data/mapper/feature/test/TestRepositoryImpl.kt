package com.juhyeon.composemvi.data.mapper.feature.test

import com.juhyeon.composemvi.data.mapper.feature.test.response.toData
import com.juhyeon.composemvi.data.mapper.feature.test.response.toDomain
import com.juhyeon.composemvi.data.mapper.toDomain
import com.juhyeon.composemvi.domain.Result
import com.juhyeon.composemvi.domain.feature.test.TestRepository
import com.juhyeon.composemvi.domain.feature.test.post.Post
import com.juhyeon.composemvi.domain.mapToResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor(
    private val testRemoteDataSource: TestRemoteDataSource,
    private val testLocalDataSource: TestLocalDataSource
) : TestRepository {
    override fun getPosts(): Flow<Result<List<Post>>> = flow {
        emit(Result.Loading)
        val result = testRemoteDataSource.getPosts()
        emit(result.toDomain { it.map { item -> item.toDomain() } })
    }

    override suspend fun insertPost(param: Post) =
        testLocalDataSource.insertPost(param.toData())

    override suspend fun deletePost(userId: Int) =
        testLocalDataSource.deletePost(userId)

    override fun getLocalPosts(): Flow<Result<List<Post>>> =
        testLocalDataSource.getPosts()
            .map { it.map { item -> item.toDomain() } }
            .mapToResult()
            .take(1)
}