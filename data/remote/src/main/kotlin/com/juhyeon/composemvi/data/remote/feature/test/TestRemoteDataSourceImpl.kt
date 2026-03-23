package com.juhyeon.composemvi.data.remote.feature.test

import com.juhyeon.composemvi.data.mapper.ResultWrapper
import com.juhyeon.composemvi.data.mapper.feature.test.TestRemoteDataSource
import com.juhyeon.composemvi.data.mapper.feature.test.response.PostData
import com.juhyeon.composemvi.data.remote.feature.test.response.toData
import com.juhyeon.composemvi.data.remote.safeApiCall
import com.juhyeon.composemvi.data.remote.service.TestService
import com.juhyeon.composemvi.shared.util.common.LogHelper
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class TestRemoteDataSourceImpl @Inject constructor(
    private val logHelper: LogHelper,
    private val testService: TestService
) : TestRemoteDataSource {
    override suspend fun getPosts(): ResultWrapper<List<PostData>> {
        return safeApiCall(Dispatchers.IO, logHelper) {
            testService.getPosts().map { it.toData() }
        }
    }
}