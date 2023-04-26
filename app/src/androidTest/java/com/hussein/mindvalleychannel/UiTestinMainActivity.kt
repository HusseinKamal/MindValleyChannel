package com.hussein.mindvalleychannel

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.hussein.mindvalleychannel.adapter.CategoryAdapter
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class UiTestinMainActivity {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    // test to check if the preferred language
    // of user is displayed under the chosen language or not
    @Test
    fun testShowHomeRecyclerView() {
        onView(withId(R.id.rvChannels)).check(matches(isDisplayed()))
    }
}