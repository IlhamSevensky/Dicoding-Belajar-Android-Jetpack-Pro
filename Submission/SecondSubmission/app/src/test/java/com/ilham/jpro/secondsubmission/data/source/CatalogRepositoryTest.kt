package com.ilham.jpro.secondsubmission.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ilham.jpro.secondsubmission.LiveDataTestUtil
import com.ilham.jpro.secondsubmission.data.source.remote.RemoteDataSource
import com.ilham.jpro.secondsubmission.utils.DataDummy
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CatalogRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val catalogRepository = FakeCatalogRepository(remote)

    private val listMovieResponse = DataDummy.generateDataMovieDummyResponse()
    private val movieId = listMovieResponse[0].id
    private val listTvShowResponse = DataDummy.generateDataTvShowDummyResponse()
    private val tvShowId = listTvShowResponse[0].id
    private val movieResponse = DataDummy.generateDataMovieDummyResponse()[0]
    private val tvShowResponse = DataDummy.generateDataTvShowDummyResponse()[0]

    @Test
    fun getNowPlayingMovies() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[0] as RemoteDataSource.LoadNowPlayingMoviesCallback).onAllMoviesReceived(listMovieResponse)
                null
            }.`when`(remote).getNowPlayingMovies(any())
        }

        val data = LiveDataTestUtil.getValue(catalogRepository.getNowPlayingMovies())

        runBlocking {
            verify(remote).getNowPlayingMovies(any())
        }

        assertNotNull(data)
        assertEquals(listMovieResponse.size.toLong(), data.size.toLong())
    }

    @Test
    fun getMovieDetail() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[1] as RemoteDataSource.LoadMovieDetailCallback).onMovieDetailReceived(movieResponse)
                null
            }.`when`(remote).getMovieDetail(eq(movieId), any())
        }

        val data = LiveDataTestUtil.getValue(catalogRepository.getMovieDetail(movieId))

        runBlocking {
            verify(remote).getMovieDetail(eq(movieId), any())
        }

        assertNotNull(data)
        assertEquals(movieResponse.id, data.id)
    }

    @Test
    fun getTvShowOnTheAir() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[0] as RemoteDataSource.LoadOnTheAirTvShowCallback).onAllTvShowsReceived(listTvShowResponse)
                null
            }.`when`(remote).getTvShowOnTheAir(any())
        }

        val data = LiveDataTestUtil.getValue(catalogRepository.getTvShowOnTheAir())

        runBlocking {
            verify(remote).getTvShowOnTheAir(any())
        }

        assertNotNull(data)
        assertEquals(listTvShowResponse.size.toLong(), data.size.toLong())
    }

    @Test
    fun getTvShowDetail() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[1] as RemoteDataSource.LoadTvShowDetailCallback).onTvShowDetailReceived(tvShowResponse)
                null
            }.`when`(remote).getTvShowDetail(eq(tvShowId), any())
        }

        val data = LiveDataTestUtil.getValue(catalogRepository.getTvShowDetail(tvShowId))

        runBlocking {
            verify(remote).getTvShowDetail(eq(tvShowId), any())
        }

        assertNotNull(data)
        assertEquals(tvShowResponse.id, data.id)
    }
}