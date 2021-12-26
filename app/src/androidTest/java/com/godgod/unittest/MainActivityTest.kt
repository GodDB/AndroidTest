package com.godgod.unittest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.test.getOrAwaitValue
import com.godgod.unittest.db.AppDataBase
import com.godgod.unittest.db.AppEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun 액티비티_클릭_이벤트() {
        //given
        launchActivity<MainActivity>()

        //when
        onView(withId(R.id.btn))
            .perform(click())

        //then
        onView(withId(R.id.tv))
            .check(matches(withText(R.string.click_complete)))
    }

    @Test
    fun 액티비티_논_클릭_상태() {
        //given
        launchActivity<MainActivity>()

        //then
        onView(withId(R.id.tv))
            .check(matches(withText(R.string.click_none)))
    }


    @ExperimentalCoroutinesApi
    @Test
    fun 액티비티_db_버튼_클릭() = runTest {
        //given
        launchActivity<MainActivity>()

        //when
        onView(withId(R.id.btn2))
            .perform(click())

        //then
        onView(withId(R.id.tv2))
            .check(matches(withText("name")))
    }
}