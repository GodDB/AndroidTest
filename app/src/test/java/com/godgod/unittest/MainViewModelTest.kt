package com.godgod.unittest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.android.architecture.blueprints.todoapp.test.getOrAwaitValue
import com.godgod.unittest.db.AppEntity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class MainViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()


    @Test
    fun 뷰모델_클릭_검증() {
        //given
        val viewModel = MainViewModel(FakeAppDataSource())

        //when
        viewModel.onClick()

        //then
        val state = viewModel.clickState.getOrAwaitValue() as ClickState.Complete
        assertEquals(state.text, ClickState.Complete().text)
    }

    @Test
    fun 뷰모델_클릭_안했을때_검증() {
        //given
        val viewModel = MainViewModel(FakeAppDataSource())
        //when

        //then
        val state = viewModel.clickState.getOrAwaitValue() as ClickState.None
        assertEquals(state.text, ClickState.None().text)
    }
}

class FakeAppDataSource() : AppDataSource {

    private val inmemory : MutableList<AppEntity> = mutableListOf()

    override suspend fun getDatas(): List<AppEntity> {
        return inmemory.toList()
    }

    override suspend fun insertAppData(appEntity: AppEntity) {
        inmemory.add(appEntity)
    }

}