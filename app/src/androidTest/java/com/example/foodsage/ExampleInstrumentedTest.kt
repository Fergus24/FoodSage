package com.example.foodsage

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_login_withEmptyFields_shouldShowError() {
        onView(withId(R.id.login)).perform(click())

        // Pause test for a while to wait for the error message to appear
        Thread.sleep(1000)

        onView(withId(R.id.username))
            .check(matches(hasErrorText("Username cannot be empty")))

        // Fill username field then attempt login again
        onView(withId(R.id.username)).perform(typeText("test_user"))
        onView(withId(R.id.login)).perform(click())
        Thread.sleep(1000)

        onView(withId(R.id.password))
            .check(matches(hasErrorText("Password cannot be empty")))
    }
}