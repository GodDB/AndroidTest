package com.godgod.unittest

import com.godgod.unittest.db.AppDao
import com.godgod.unittest.db.AppEntity
import javax.inject.Inject

interface AppDataSource {

    suspend fun getDatas() : List<AppEntity>

    suspend fun insertAppData(appEntity: AppEntity)
}

class AppDataSourceImpl @Inject constructor(private val dao : AppDao) : AppDataSource {
    override suspend fun getDatas(): List<AppEntity> {
        return dao.getDatas()
    }

    override suspend fun insertAppData(appEntity: AppEntity) {
        dao.insertData(appEntity)
    }
}