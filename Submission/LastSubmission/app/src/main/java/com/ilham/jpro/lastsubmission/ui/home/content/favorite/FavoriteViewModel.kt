package com.ilham.jpro.lastsubmission.ui.home.content.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ilham.jpro.lastsubmission.data.source.CatalogRepository
import com.ilham.jpro.lastsubmission.data.source.local.entity.MovieEntity
import com.ilham.jpro.lastsubmission.data.source.local.entity.TvShowEntity
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(private val catalogRepository: CatalogRepository) : ViewModel() {

    fun getListFavoriteMovie(): LiveData<PagedList<MovieEntity>> = catalogRepository.getListFavoriteMovies()

    fun getListFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> = catalogRepository.getListFavoriteTvShows()
}