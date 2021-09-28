package com.gustavothirion.githubdatarepositories

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.PerformException
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gustavothirion.githubdatarepositories.adapter.RepositoryViewHolder
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun test_isListVisible_onAppLaunch() {

        onView(withId(R.id.recyclerview_list)).check(matches(isDisplayed()))
    }

    @Test(expected = PerformException::class)
    fun itemWithText_doesNotExist() {

        onView(withId(R.id.recyclerview_list))
            .perform(
                RecyclerViewActions.scrollTo<RepositoryViewHolder>(
                    hasDescendant(withText("not in the list"))
                )
            )
    }

    @Test(expected = PerformException::class)
    fun itemWithText_doesExist() {

        onView(withId(R.id.recyclerview_list))
            .perform(
                RecyclerViewActions.scrollTo<RepositoryViewHolder>(
                    hasDescendant(withText("Stars"))
                )
            )
        onView(withId(R.id.recyclerview_list))
            .perform(
                RecyclerViewActions.scrollTo<RepositoryViewHolder>(
                    hasDescendant(withText("Forks"))
                )
            )
        onView(withId(R.id.recyclerview_list))
            .perform(
                RecyclerViewActions.scrollTo<RepositoryViewHolder>(
                    hasDescendant(withText("Author"))
                )
            )
        onView(withId(R.id.recyclerview_list))
            .perform(
                RecyclerViewActions.scrollTo<RepositoryViewHolder>(
                    hasDescendant(withText("Repository"))
                )
            )
    }

//    @Test
//    fun clickButtonMoreAboutIt_checkDescriptionText() {
//
//        onView(withId(R.id.recyclerview_list))
//            .perform(
//                RecyclerViewActions.actionOnItem<RepositoryViewHolder>(
//                    hasDescendant(withId(R.id.description_btn)),
//                    click()
//                )
//            )
//        Thread.sleep(4000)
//    }
//
//    @Test
//    fun test() {
//
//        onView(allOf(isDisplayed(), withId(R.id.recyclerview_list)))
//            .perform(
//                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
//                    1,
//                    click()
//                )
//            );
//
//        Thread.sleep(3000)
//    }
}
