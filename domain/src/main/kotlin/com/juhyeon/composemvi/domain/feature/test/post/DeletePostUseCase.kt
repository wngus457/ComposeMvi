package com.juhyeon.composemvi.domain.feature.test.post

import com.juhyeon.composemvi.domain.FlowUseCase
import com.juhyeon.composemvi.domain.Result
import com.juhyeon.composemvi.domain.annotation.DefaultDispatcher
import com.juhyeon.composemvi.domain.feature.test.TestRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(
    private val testRepository: TestRepository,
    @param:DefaultDispatcher private val dispatcher: CoroutineDispatcher
) : FlowUseCase<Int, Unit>(dispatcher) {
    override fun execute(parameters: Int): Flow<Result<Unit>> = flow {
        emit(Result.Success(testRepository.deletePost(parameters)))
    }
}