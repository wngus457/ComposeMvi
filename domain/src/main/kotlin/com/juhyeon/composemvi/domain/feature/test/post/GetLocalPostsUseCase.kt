package com.juhyeon.composemvi.domain.feature.test.post

import com.juhyeon.composemvi.domain.FlowNoParamUseCase
import com.juhyeon.composemvi.domain.Result
import com.juhyeon.composemvi.domain.annotation.DefaultDispatcher
import com.juhyeon.composemvi.domain.feature.test.TestRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocalPostsUseCase @Inject constructor(
    private val testRepository: TestRepository,
    @param:DefaultDispatcher private val dispatcher: CoroutineDispatcher
) : FlowNoParamUseCase<List<Post>>(dispatcher) {

    override fun execute(): Flow<Result<List<Post>>> {
        return testRepository.getLocalPosts()
    }
}