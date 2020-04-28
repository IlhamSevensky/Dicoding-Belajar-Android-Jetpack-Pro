package com.ilham.jpro.secondsubmission.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ilham.jpro.secondsubmission.data.DataModel
import com.ilham.jpro.secondsubmission.data.source.CatalogRepository

class HomeViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {

    fun getListNowPlayingMovies(): LiveData<List<DataModel>> = catalogRepository.getNowPlayingMovies()

    fun getListOnTheAirTvShows(): LiveData<List<DataModel>> = catalogRepository.getTvShowOnTheAir()

}