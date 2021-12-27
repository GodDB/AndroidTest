package com.godgod.unittest.fake

import com.godgod.unittest.AppDataSource
import com.godgod.unittest.db.AppEntity

class FakeAppDataSource() : AppDataSource {

    private val inmemory: MutableList<AppEntity> = mutableListOf(
        AppEntity(0, "1"),
        AppEntity(1, "2"),
        AppEntity(2, "3"),
        AppEntity(3, "4"),
        AppEntity(4, "5"),
        AppEntity(5, "6"),
        AppEntity(6, "7"),
        AppEntity(7, "8"),
        AppEntity(8, "9"),
        AppEntity(9, "10")
    )

    override suspend fun getDatas(): List<AppEntity> {
        return inmemory.toList()
    }

    override suspend fun insertAppData(appEntity: AppEntity) {
        inmemory.add(appEntity)
    }

}