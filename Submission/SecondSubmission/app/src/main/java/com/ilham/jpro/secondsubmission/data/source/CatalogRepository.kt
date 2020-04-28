package com.ilham.jpro.secondsubmission.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilham.jpro.secondsubmission.data.DataModel
import com.ilham.jpro.secondsubmission.data.source.remote.RemoteDataSource
import com.ilham.jpro.secondsubmission.data.source.remote.response.MovieResponse
import com.ilham.jpro.secondsubmission.data.source.remote.response.TvShowResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class CatalogRepository private constructor(private val remoteDataSource: RemoteDataSource) : CatalogDataSource {

    companion object {
        @Volatile
        private var instance: CatalogRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): CatalogRepository =
            instance ?: synchronized(this) {
                instance ?: CatalogRepository(remoteDataSource)
            }
    }

    override fun getNowPlayingMovies(): LiveData<List<DataModel>> {
        val listMovieResult = MutableLiveData<List<DataModel>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getNowPlayingMovies(object : RemoteDataSource.LoadNowPlayingMoviesCallback{
                override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                    val movieList = ArrayList<DataModel>()
                    for (response in movieResponse){
                        val movie = DataModel(
                            response.id,
                            response.name,
                            response.desc,
                            response.poster,
                            response.img_preview
                        )
                        movieList.add(movie)
                    }
                    listMovieResult.postValue(movieList)
                }
            })
        }

        return listMovieResult
    }

    override fun getMovieDetail(movieId: Int): LiveData<DataModel> {
        val movieResult = MutableLiveData<DataModel>()
        CoroutineScope(IO).launch {
            remoteDataSource.getMovieDetail(movieId, object : RemoteDataSource.LoadMovieDetailCallback{
                override fun onMovieDetailReceived(movieResponse: MovieResponse) {
                    val movie = DataModel(
                        movieResponse.id,
                        movieResponse.name,
                        movieResponse.desc,
                        movieResponse.poster,
                        movieResponse.img_preview
                    )

                    movieResult.postValue(movie)
                }
            })
        }

        return movieResult
    }

    override fun getTvShowOnTheAir(): LiveData<List<DataModel>> {
        val listTvShowResult = MutableLiveData<List<DataModel>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTvShowOnTheAir(object : RemoteDataSource.LoadOnTheAirTvShowCallback{
                override fun onAllTvShowsReceived(tvShowResponse: List<TvShowResponse>) {
                    val tvShowList = ArrayList<DataModel>()
                    for (response in tvShowResponse){
                        val tvShow = DataModel(
                            response.id,
                            response.name,
                            response.desc,
                            response.poster,
                            response.img_preview
                        )
                        tvShowList.add(tvShow)
                    }

                    listTvShowResult.postValue(tvShowList)
                }
            })
        }

        return listTvShowResult
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<DataModel> {
        val tvShowResult = MutableLiveData<DataModel>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTvShowDetail(tvShowId, object : RemoteDataSource.LoadTvShowDetailCallback{
                override fun onTvShowDetailReceived(tvShowResponse: TvShowResponse) {
                    val tvShow = DataModel(
                        tvShowResponse.id,
                        tvShowResponse.name,
                        tvShowResponse.desc,
                        tvShowResponse.poster,
                        tvShowResponse.img_preview
                    )

                    tvShowResult.postValue(tvShow)
                }
            })
        }

        return tvShowResult
    }

}