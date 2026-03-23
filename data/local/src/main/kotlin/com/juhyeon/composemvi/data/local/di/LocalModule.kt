package com.juhyeon.composemvi.data.local.di

import android.content.Context
import com.juhyeon.composemvi.data.local.db.AppDatabase
import com.juhyeon.composemvi.data.local.feature.test.TestDao
import com.juhyeon.composemvi.data.local.feature.test.TestLocalDataSourceImpl
import com.juhyeon.composemvi.data.mapper.feature.test.TestLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalModule {

    @Singleton
    @Binds
    abstract fun bindTestLocalDataSource(source: TestLocalDataSourceImpl): TestLocalDataSource

    companion object {
        @Singleton
        @Provides
        fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase = AppDatabase.buildDatabase(context)

        @Singleton
        @Provides
        fun provideTestDao(appDatabase: AppDatabase): TestDao = appDatabase.testDao()
    }
}