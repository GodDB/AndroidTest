package com.godgod.unittest.di

import com.godgod.unittest.AppDataSource
import com.godgod.unittest.fake.FakeAppDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton
import javax.sql.DataSource

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DatasourceModule::class]
)
class TestDataSourceModule {

    @Singleton
    @Provides
    fun provideFakeDataSource() : AppDataSource {
        return FakeAppDataSource()
    }
}