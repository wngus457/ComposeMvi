package com.juhyeon.composemvi.shared.util.common.di

import com.juhyeon.composemvi.shared.util.common.LogHelper
import com.juhyeon.composemvi.shared.util.common.LogHelperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UtilModule {

    @Singleton
    @Binds
    abstract fun provideLogHelper(logHelper: LogHelperImpl): LogHelper
}