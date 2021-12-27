package com.godgod.unittest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.godgod.unittest.testUtil.RecyclerViewUtil
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class Main2ActivityTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity2::class.java)

    @Before
    fun before() {
        hiltRule.inject()
    }

    @Test
    fun 리사이클러뷰_아이템_1번_버튼_클릭() {

        onView(ViewMatchers.withId(R.id.rv))
            .perform(RecyclerViewActions.actionOnItemAtPosition<TestViewHolder>(0, RecyclerViewUtil.clickChildViewWithId(R.id.test_btn1)))

        onView(ViewMatchers.withId(R.id.tv1))
            .check(matches(withText("1")))
    }

    @Test
    fun 리사이클러뷰_아이템_2번_버튼_클릭() {
        onView(ViewMatchers.withId(R.id.rv))
            .perform(RecyclerViewActions.actionOnItemAtPosition<TestViewHolder>(0, RecyclerViewUtil.clickChildViewWithId(R.id.test_btn2)))

        onView(ViewMatchers.withId(R.id.tv2))
            .check(matches(withText("1")))
    }

    @Test
    fun 리사이클러뷰_7번째_아이템_1번_버튼_클릭() {
        onView(ViewMatchers.withId(R.id.rv))
            .perform(RecyclerViewActions.actionOnItemAtPosition<TestViewHolder>(7, RecyclerViewUtil.clickChildViewWithId(R.id.test_btn1)))

        onView(ViewMatchers.withId(R.id.tv1))
            .check(matches(withText("8")))
    }

    @Test
    fun 리사이클러뷰_7번째_아이템_2번_버튼_클릭() {
        onView(ViewMatchers.withId(R.id.rv))
            .perform(RecyclerViewActions.actionOnItemAtPosition<TestViewHolder>(7, RecyclerViewUtil.clickChildViewWithId(R.id.test_btn2)))

        onView(ViewMatchers.withId(R.id.tv2))
            .check(matches(withText("8")))
    }
}
