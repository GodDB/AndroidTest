package com.godgod.unittest.testUtil

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import org.hamcrest.Matcher

object RecyclerViewUtil {

    fun clickChildViewWithId(id: Int): ViewAction {
        return object : ViewAction {
            private val c : ViewAction = click()

            override fun getConstraints(): Matcher<View>? {
                return c.constraints
            }

            override fun getDescription(): String {
                return "Click on a child view with specified id."
            }

            override fun perform(uiController: UiController?, view: View) {
                c.perform(uiController, view.findViewById(id))
            }
        }
    }
}