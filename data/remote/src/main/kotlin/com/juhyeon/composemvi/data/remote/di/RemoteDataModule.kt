package com.juhyeon.composemvi.data.remote.di

import com.juhyeon.composemvi.data.mapper.feature.test.TestRemoteDataSource
import com.juhyeon.composemvi.data.remote.feature.test.TestRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataModule {

    @Singleton
    @Binds
    abstract fun bindTestRemoteDataSource(source: TestRemoteDataSourceImpl): TestRemoteDataSource

}