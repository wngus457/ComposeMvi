package com.juhyeon.composemvi.data.mapper.feature.test

import com.juhyeon.composemvi.data.mapper.ResultWrapper
import com.juhyeon.composemvi.data.mapper.feature.test.response.PostData

interface TestRemoteDataSource {
    suspend fun getPosts(): ResultWrapper<List<PostData>>
}