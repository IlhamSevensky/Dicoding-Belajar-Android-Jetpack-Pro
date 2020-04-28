package com.ilham.jpro.firstsubmission.ui.home

import junit.framework.TestCase.assertNotNull
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        viewModel = HomeViewModel()
    }

    @Test
    fun getListMovie() {
        val movies = viewModel.getListMovie()
        assertNotNull(movies)
        assertNotNull(movies)
        assertEquals(10, movies.size)
    }

    @Test
    fun getListTvShow() {
        val tvShows = viewModel.getListTvShow()
        assertNotNull(tvShows)
        assertEquals(10, tvShows.size)
    }
}