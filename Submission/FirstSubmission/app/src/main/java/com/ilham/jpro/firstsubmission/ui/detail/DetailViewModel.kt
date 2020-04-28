package com.ilham.jpro.firstsubmission.ui.detail

import androidx.lifecycle.ViewModel
import com.ilham.jpro.firstsubmission.model.DataModel
import com.ilham.jpro.firstsubmission.utils.DataDummy

class DetailViewModel : ViewModel() {

    private lateinit var movieId: String
    private lateinit var tvShowId: String

    private fun getListMovie(): ArrayList<DataModel> = DataDummy.generateDataMovieDummy() as ArrayList<DataModel>
    private fun getListTvShow(): ArrayList<DataModel> = DataDummy.generateDataTvShowDummy() as ArrayList<DataModel>

    fun setMovieId(movieId: String){
        this.movieId = movieId
    }

    fun setTvShowId(tvShowId: String){
        this.tvShowId = tvShowId
    }

    fun getDetailMovieById(): DataModel {
        lateinit var result: DataModel
        val listMovie = getListMovie()
        for (movie in listMovie){
            if (movie.id == movieId){
                result = movie
                break
            }
        }
        return result
    }

    fun getDetailTvShowById(): DataModel {
        lateinit var result: DataModel
        val listTvShow = getListTvShow()
        for (tvShow in listTvShow){
            if (tvShow.id == tvShowId){
                result = tvShow
                break
            }
        }
        return result
    }

}