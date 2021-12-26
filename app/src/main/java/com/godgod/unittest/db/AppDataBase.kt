package com.godgod.unittest.db

import android.content.Context
import androidx.room.*

@Database(version = 1, entities = [AppEntity::class])
abstract class AppDataBase : RoomDatabase() {

    companion object {
        @Volatile
        var INSTANCE: AppDataBase? = null

        fun create(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(AppDataBase::class.java) {
                Room.databaseBuilder(context, AppDataBase::class.java, "db.sqlite3")
                    .build().also {
                    INSTANCE = it
                }
            }
        }

        fun createInMemory(context: Context): AppDataBase {
            return Room.inMemoryDatabaseBuilder(context, AppDataBase::class.java)
                .build()
        }
    }

    abstract fun getDao(): AppDao
}

@Dao
interface AppDao {

    @Insert
    suspend fun insertData(appEntity: AppEntity)

    @Query("select * from AppEntity")
    suspend fun getDatas(): List<AppEntity>
}

@Entity
data class AppEntity(
    @PrimaryKey(autoGenerate = false)
    val pk: Int,
    val name: String
)