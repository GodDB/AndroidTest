package com.godgod.unittest.di

import android.content.Context
import com.godgod.unittest.db.AppDao
import com.godgod.unittest.db.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DBModule {

    @Provides
    @Singleton
    fun provideDao(@ApplicationContext context: Context) : AppDao {
        return AppDataBase.create(context).getDao()
    }
}