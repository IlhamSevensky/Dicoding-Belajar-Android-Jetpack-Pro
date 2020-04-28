package com.ilham.jpro.secondsubmission.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ilham.jpro.secondsubmission.data.DataModel
import com.ilham.jpro.secondsubmission.data.source.CatalogRepository
import com.ilham.jpro.secondsubmission.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    private val dummyMovie = DataDummy.generateDataMovieDummy()
    private val dummyTvShow = DataDummy.generateDataTvShowDummy()

    private lateinit var viewModel: HomeViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogRepository: CatalogRepository

    @Mock
    private lateinit var observer: Observer<List<DataModel>>

    @Before
    fun setUp() {
        viewModel = HomeViewModel(catalogRepository)
    }

    @Test
    fun getListNowPlayingMovies() {
        val movie = MutableLiveData<List<DataModel>>()
        movie.value = dummyMovie

        `when`(catalogRepository.getNowPlayingMovies()).thenReturn(movie)

        val dataListMovie = viewModel.getListNowPlayingMovies().value

        verify(catalogRepository).getNowPlayingMovies()
        assertNotNull(dataListMovie)
        assertEquals(10, dataListMovie?.size)

        viewModel.getListNowPlayingMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }

    @Test
    fun getListOnTheAirTvShows() {
        val tvShow = MutableLiveData<List<DataModel>>()
        tvShow.value = dummyTvShow

        `when`(catalogRepository.getTvShowOnTheAir()).thenReturn(tvShow)

        val dataListTvShow = viewModel.getListOnTheAirTvShows().value

        verify(catalogRepository).getTvShowOnTheAir()
        assertNotNull(dataListTvShow)
        assertEquals(10, dataListTvShow?.size)

        viewModel.getListOnTheAirTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}