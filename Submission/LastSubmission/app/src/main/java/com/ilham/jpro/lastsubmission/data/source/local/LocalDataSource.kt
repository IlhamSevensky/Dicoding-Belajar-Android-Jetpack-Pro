package com.ilham.jpro.lastsubmission.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.ilham.jpro.lastsubmission.data.source.local.entity.MovieEntity
import com.ilham.jpro.lastsubmission.data.source.local.entity.TvShowEntity
import com.ilham.jpro.lastsubmission.data.source.local.room.CatalogDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val catalogDao: CatalogDao) {

    fun getListMovies() : DataSource.Factory<Int, MovieEntity> = catalogDao.getListMovies()

    fun getListFavoriteMovies() : DataSource.Factory<Int, MovieEntity> = catalogDao.getListFavoriteMovies()

    fun getListTvShows() : DataSource.Factory<Int, TvShowEntity> = catalogDao.getListTvShows()

    fun getListFavoriteTvShows() : DataSource.Factory<Int, TvShowEntity> = catalogDao.getListFavoriteTvShows()

    fun getDetailMovie(movieId: Int) : LiveData<MovieEntity> = catalogDao.getDetailMovieById(movieId)

    fun getDetailTvShow(tvShowId: Int) : LiveData<TvShowEntity> = catalogDao.getDetailTvShowById(tvShowId)

    fun insertMovies(movies: List<MovieEntity>) = catalogDao.insertMovies(movies)

    fun insertTvShows(tvShows: List<TvShowEntity>) = catalogDao.insertTvShows(tvShows)

    fun setFavoriteMovie(movie : MovieEntity) {
        movie.isFavorite = !movie.isFavorite
        catalogDao.updateMovie(movie)
    }

    fun setFavoriteTvShow(tvShow : TvShowEntity) {
        tvShow.isFavorite = !tvShow.isFavorite
        catalogDao.updateTvShow(tvShow)
    }
}