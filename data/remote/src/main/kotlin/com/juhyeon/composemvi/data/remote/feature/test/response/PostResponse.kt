package com.juhyeon.composemvi.data.remote.feature.test.response

import com.juhyeon.composemvi.data.mapper.feature.test.response.PostData
import com.squareup.moshi.Json

data class PostResponse(
    @param:Json(name = "userId")
    val userId: Int,
    @param:Json(name = "id")
    val id: Int,
    @param:Json(name = "title")
    val title: String,
    @param:Json(name = "body")
    val body: String
)

internal fun PostResponse.toData() = PostData(
    userId = userId,
    id = id,
    title = title,
    body = body
)