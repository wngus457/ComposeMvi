package com.juhyeon.composemvi.data.mapper.feature.test.response

import com.juhyeon.composemvi.domain.feature.test.post.Post

data class PostData(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

internal fun PostData.toDomain() = Post(
    userId = userId,
    id = id,
    title = title,
    body = body
)

internal fun Post.toData() = PostData(
    userId = userId,
    id = id,
    title = title,
    body = body
)