package com.godgod.unittest.di

import com.godgod.unittest.AppDataSource
import com.godgod.unittest.AppDataSourceImpl
import com.godgod.unittest.db.AppDao
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DatasourceModule {

    @Binds
    abstract fun bindAppDataSource(appDataSourceImpl: AppDataSourceImpl): AppDataSource
}