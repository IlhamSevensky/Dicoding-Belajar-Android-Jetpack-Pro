package com.ilham.jpro.lastsubmission.ui.detail

import android.graphics.Color
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.ilham.jpro.lastsubmission.BuildConfig
import com.ilham.jpro.lastsubmission.R
import com.ilham.jpro.lastsubmission.data.source.local.entity.MovieEntity
import com.ilham.jpro.lastsubmission.data.source.local.entity.TvShowEntity
import com.ilham.jpro.lastsubmission.utils.Constants
import com.ilham.jpro.lastsubmission.utils.Constants.TYPE_MOVIE
import com.ilham.jpro.lastsubmission.utils.Constants.TYPE_TVSHOW
import com.ilham.jpro.lastsubmission.utils.loadFromUrl
import com.ilham.jpro.lastsubmission.viewmodel.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*
import javax.inject.Inject

class DetailActivity : DaggerAppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var viewModel: DetailViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupToolbar()
        setupViewModel()

        val id = intent.getIntExtra(EXTRA_DATA, 0)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MOVIE, ignoreCase = true)) {
            setupToolbarTitle(resources.getString(R.string.toolbar_title_detail_movie))
            observeDetailMovie(id)

        } else if (type.equals(TYPE_TVSHOW, ignoreCase = true)) {
            setupToolbarTitle(resources.getString(R.string.toolbar_title_detail_tvshow))
            observeDetailTvShow(id)
        }

    }

    private fun observeDetailMovie(movieId: Int) {
        viewModel.getMovieDetail(movieId).observe(this, Observer {
            displayData(it, null)
        })
    }

    private fun observeDetailTvShow(tvShowId: Int) {
        viewModel.getTvShowDetail(tvShowId).observe(this, Observer {
            it?.let {
                displayData(null, it)
            }
        })
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this@DetailActivity,
            factory
        )[DetailViewModel::class.java]
    }

    private fun displayData(movie: MovieEntity?, tvShow: TvShowEntity?) {
        val urlImage = movie?.poster ?: tvShow?.poster
        val urlHighlight = movie?.imgPreview ?: tvShow?.imgPreview
        val statusFavorite = movie?.isFavorite ?: tvShow?.isFavorite

        tv_detail_name.text = movie?.name ?: tvShow?.name
        tv_detail_desc.text = movie?.desc ?: tvShow?.desc

        statusFavorite?.let { status ->
            setFavoriteState(status)
        }

        img_detail_poster.loadFromUrl(BuildConfig.BASE_URL_IMAGE_TMDB + Constants.ENDPOINT_POSTER_SIZE_W185 + urlImage)
        img_detail_hightlight.loadFromUrl(BuildConfig.BASE_URL_IMAGE_TMDB + Constants.ENDPOINT_POSTER_SIZE_W780 + urlHighlight)

        fab_favorite.setOnClickListener {
            setFavorite(movie, tvShow)
        }

    }

    private fun setFavoriteState(status: Boolean){
        if (status) {
            fab_favorite.setImageResource(R.drawable.ic_favorite_true)
        } else {
            fab_favorite.setImageResource(R.drawable.ic_favorite_false)
        }
    }

    private fun showSnackBar(msg: String) {
        Snackbar.make(findViewById(android.R.id.content), msg, Snackbar.LENGTH_SHORT).show()
    }

    private fun setFavorite(movie: MovieEntity?, tvShow: TvShowEntity?) {
        if (movie != null) {
            if (movie.isFavorite){
                showSnackBar("${movie.name} Removed from favorite")
            }else {
                showSnackBar("${movie.name} Added to favorite")
            }
            viewModel.setFavoriteMovie(movie)
        } else {
            if (tvShow != null) {
                if (tvShow.isFavorite){
                    showSnackBar("${tvShow.name} Aemoved from favorite")
                }else {
                    showSnackBar("${tvShow.name} Removed from favorite")
                }
                viewModel.setFavoriteTvShow(tvShow)
            }
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(detail_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsing_toolbar.setExpandedTitleColor(Color.TRANSPARENT)
    }

    private fun setupToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}
