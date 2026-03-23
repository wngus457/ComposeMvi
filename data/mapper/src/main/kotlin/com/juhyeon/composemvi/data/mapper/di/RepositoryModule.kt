package com.juhyeon.composemvi.data.mapper.di

import com.juhyeon.composemvi.data.mapper.feature.test.TestRepositoryImpl
import com.juhyeon.composemvi.domain.feature.test.TestRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindTestRepository(repository: TestRepositoryImpl): TestRepository

}