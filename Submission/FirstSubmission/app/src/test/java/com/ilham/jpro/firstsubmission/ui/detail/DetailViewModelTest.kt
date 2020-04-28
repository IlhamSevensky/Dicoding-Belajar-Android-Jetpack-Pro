package com.ilham.jpro.firstsubmission.ui.detail

import com.ilham.jpro.firstsubmission.utils.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDataMovieDummy()[0]
    private val dummyTvShow = DataDummy.generateDataTvShowDummy()[0]
    private val movieId = dummyMovie.id
    private val tvShowId = dummyTvShow.id

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setMovieId(movieId)
        viewModel.setTvShowId(tvShowId)
    }

    @Test
    fun getDetailMovieById() {
        val movie = viewModel.getDetailMovieById()
        assertNotNull(movie)
        assertEquals(dummyMovie.name, movie.name)
        assertEquals(dummyMovie.desc, movie.desc)
        assertEquals(dummyMovie.poster, movie.poster)
        assertEquals(dummyMovie.img_preview, movie.img_preview)
    }

    @Test
    fun getDetailTvShowById() {
        val tvShow = viewModel.getDetailTvShowById()
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.name, tvShow.name)
        assertEquals(dummyTvShow.desc, tvShow.desc)
        assertEquals(dummyTvShow.poster, tvShow.poster)
        assertEquals(dummyTvShow.img_preview, tvShow.img_preview)
    }
}