package com.juhyeon.composemvi.data.local.feature.test

import com.juhyeon.composemvi.data.mapper.feature.test.TestLocalDataSource
import com.juhyeon.composemvi.data.mapper.feature.test.response.PostData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TestLocalDataSourceImpl @Inject constructor(
    private val testDao: TestDao
) : TestLocalDataSource {
    override suspend fun insertPost(param: PostData) =
        testDao.insertPost(param.toEntity())

    override suspend fun deletePost(userId: Int) =
        testDao.deletePost(userId = userId)

    override fun getPosts(): Flow<List<PostData>> =
        testDao.getPosts().map { it.map { item -> item.toData() } }
}