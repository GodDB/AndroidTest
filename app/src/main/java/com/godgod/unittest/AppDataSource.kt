package com.godgod.unittest

import com.godgod.unittest.db.AppDao
import com.godgod.unittest.db.AppEntity

interface AppDataSource {

    suspend fun getDatas() : List<AppEntity>

    suspend fun insertAppData(appEntity: AppEntity)
}

class AppDataSourceImpl(private val dao : AppDao) : AppDataSource {
    override suspend fun getDatas(): List<AppEntity> {
        return dao.getDatas()
    }

    override suspend fun insertAppData(appEntity: AppEntity) {
        dao.insertData(appEntity)
    }
}