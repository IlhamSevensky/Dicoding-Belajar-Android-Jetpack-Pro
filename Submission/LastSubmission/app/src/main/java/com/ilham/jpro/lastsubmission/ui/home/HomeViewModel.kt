package com.ilham.jpro.lastsubmission.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ilham.jpro.lastsubmission.data.source.CatalogRepository
import com.ilham.jpro.lastsubmission.data.source.local.entity.MovieEntity
import com.ilham.jpro.lastsubmission.data.source.local.entity.TvShowEntity
import com.ilham.jpro.lastsubmission.vo.Resource
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val catalogRepository: CatalogRepository) :
    ViewModel() {

    fun getListNowPlayingMovies(): LiveData<Resource<PagedList<MovieEntity>>> = catalogRepository.getNowPlayingMovies()

    fun getListOnTheAirTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> = catalogRepository.getTvShowOnTheAir()

}