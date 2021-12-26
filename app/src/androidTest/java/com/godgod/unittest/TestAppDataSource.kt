package com.godgod.unittest

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.godgod.unittest.db.AppDataBase
import com.godgod.unittest.db.AppEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(AndroidJUnit4::class)
class TestAppDataSource {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    lateinit var db: AppDataBase

    @ExperimentalCoroutinesApi
    @Before
    fun before() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext<Context>(), AppDataBase::class.java
        ).build()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun appData를_insert_한다() = runBlockingTest {
        //given
        val dataSource = AppDataSourceImpl(db.getDao())

        //when
        val appData = AppEntity(0, "name")
        dataSource.insertAppData(appData)
        val result = dataSource.getDatas()

        //then
        assertEquals(result.first(), AppEntity(0, "name"))
    }

    @ExperimentalCoroutinesApi
    @After
    fun after() {
        db.close()
    }
}