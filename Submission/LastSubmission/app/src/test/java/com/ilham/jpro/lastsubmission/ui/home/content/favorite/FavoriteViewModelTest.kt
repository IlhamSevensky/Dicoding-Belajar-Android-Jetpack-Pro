package com.ilham.jpro.lastsubmission.ui.home.content.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.ilham.jpro.lastsubmission.data.source.CatalogRepository
import com.ilham.jpro.lastsubmission.data.source.local.entity.MovieEntity
import com.ilham.jpro.lastsubmission.data.source.local.entity.TvShowEntity
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogRepository: CatalogRepository

    @Mock
    private lateinit var observerMovie: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var observerTvShow: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>

    @Mock
    private lateinit var tvShowPagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(catalogRepository)
    }

    @Test
    fun getListFavoriteMovie() {

        val dummyMovie = moviePagedList
        Mockito.`when`(dummyMovie.size).thenReturn(5)
        val movie = MutableLiveData<PagedList<MovieEntity>>()
        movie.value = dummyMovie

        Mockito.`when`(catalogRepository.getListFavoriteMovies()).thenReturn(movie)
        val movieEntity = viewModel.getListFavoriteMovie().value
        Mockito.verify(catalogRepository).getListFavoriteMovies()
        Assert.assertNotNull(movieEntity)
        Assert.assertEquals(5, movieEntity?.size)

        viewModel.getListFavoriteMovie().observeForever(observerMovie)
        Mockito.verify(observerMovie).onChanged(dummyMovie)

    }

    @Test
    fun getListFavoriteTvShow() {
        val dummyTvShow = tvShowPagedList
        Mockito.`when`(dummyTvShow.size).thenReturn(5)
        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()
        tvShow.value = dummyTvShow

        Mockito.`when`(catalogRepository.getListFavoriteTvShows()).thenReturn(tvShow)
        val tvShowEntity = viewModel.getListFavoriteTvShow().value
        Mockito.verify(catalogRepository).getListFavoriteTvShows()
        Assert.assertNotNull(tvShowEntity)
        Assert.assertEquals(5, tvShowEntity?.size)

        viewModel.getListFavoriteTvShow().observeForever(observerTvShow)
        Mockito.verify(observerTvShow).onChanged(dummyTvShow)
    }
}
