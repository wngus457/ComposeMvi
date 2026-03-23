package com.juhyeon.composemvi.data.local.feature.test

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.juhyeon.composemvi.data.mapper.feature.test.response.PostData

@Entity(tableName = "test")
data class PostEntity(
    @PrimaryKey
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

internal fun PostEntity.toData() = PostData(
    userId = userId,
    id = id,
    title = title,
    body = body
)

internal fun PostData.toEntity() = PostEntity(
    userId = userId,
    id = id,
    title = title,
    body = body
)