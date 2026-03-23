package com.juhyeon.composemvi.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.juhyeon.composemvi.data.local.feature.test.PostEntity
import com.juhyeon.composemvi.data.local.feature.test.TestDao

@Database(
    entities = [
        PostEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun testDao(): TestDao

    companion object {
        private const val DATABASE_NAME = "test-room-db"

        fun buildDatabase(context: Context) = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration(false)
            .build()
    }
}