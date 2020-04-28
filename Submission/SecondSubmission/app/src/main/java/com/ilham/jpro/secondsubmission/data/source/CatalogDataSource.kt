package com.ilham.jpro.secondsubmission.data.source

import androidx.lifecycle.LiveData
import com.ilham.jpro.secondsubmission.data.DataModel

interface CatalogDataSource {

    fun getNowPlayingMovies(): LiveData<List<DataModel>>

    fun getMovieDetail(movieId: Int): LiveData<DataModel>

    fun getTvShowOnTheAir(): LiveData<List<DataModel>>

    fun getTvShowDetail(tvShowId: Int): LiveData<DataModel>

}