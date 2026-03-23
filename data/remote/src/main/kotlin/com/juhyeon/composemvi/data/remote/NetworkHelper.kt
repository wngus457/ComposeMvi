package com.juhyeon.composemvi.data.remote

import com.juhyeon.composemvi.data.mapper.ResultWrapper
import com.juhyeon.composemvi.shared.util.common.LogHelper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    logHelper: LogHelper,
    apiCall: suspend () -> T
): ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> ResultWrapper.NetworkError
                is HttpException -> {
                    ResultWrapper.GenericError(
                        message = throwable.message ?: "",
                        exception = throwable
                    )
                }
                else -> {
                    logHelper.log(throwable.stackTraceToString())
                    ResultWrapper.GenericError(
                        message = "일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요.",
                        exception = null
                    )
                }
            }
        }
    }
}