package com.ilham.jpro.firstsubmission.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.ilham.jpro.firstsubmission.R
import com.ilham.jpro.firstsubmission.utils.DataDummy
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDataMovieDummy()
    private val dummyTvShow = DataDummy.generateDataTvShowDummy()

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun loadMovieAndTvShow() {
        onView(withId(R.id.rv_movie))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))

        onView(withId(R.id.nav_tvshow)).perform(click())
        onView(withId(R.id.rv_tvshow))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))

        onView(withId(R.id.nav_movie)).perform(click())
    }

    @Test
    fun detailMovie() {
        onView(withId(R.id.rv_movie))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))

        onView(withId(R.id.img_detail_hightlight))
            .check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_poster))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_name))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_desc))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tv_detail_name))
            .check(matches(withText(dummyMovie[5].name)))
        onView(withId(R.id.tv_detail_desc))
            .check(matches(withText(dummyMovie[5].desc)))

        pressBack()
    }

    @Test
    fun detailTvShow() {
        onView(withId(R.id.nav_tvshow)).perform(click())
        onView(withId(R.id.rv_tvshow))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
        onView(withId(R.id.rv_tvshow))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))

        onView(withId(R.id.img_detail_hightlight))
            .check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_poster))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_name))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_desc))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_name))
            .check(matches(withText(dummyTvShow[5].name)))
        onView(withId(R.id.tv_detail_desc))
            .check(matches(withText(dummyTvShow[5].desc)))

        pressBack()
    }
}