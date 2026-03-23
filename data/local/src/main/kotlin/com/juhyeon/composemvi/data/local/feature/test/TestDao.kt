package com.juhyeon.composemvi.data.local.feature.test

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(postEntity: PostEntity)

    @Query("DELETE FROM test WHERE userId = :userId")
    suspend fun deletePost(userId: Int)

    @Query("SELECT * FROM test")
    fun getPosts(): Flow<List<PostEntity>>
}