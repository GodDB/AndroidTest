package com.godgod.unittest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Main2ActivityTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity2::class.java)

    val dataSource : FakeAppDataSource = FakeAppDataSource()


    @Before
    fun before() {

    }

    @Test
    fun 리사이클러뷰_아이템_1번_버튼_클릭() {

        onView(R.id.rv)
            .perform(RecyclerViewActions)
    }

    @Test
    fun 리사이클러뷰_아이템_2번_버튼_클릭() {

    }
 }