package com.ilham.jpro.lastsubmission.ui.home.content.favorite.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilham.jpro.lastsubmission.R
import com.ilham.jpro.lastsubmission.data.source.local.entity.MovieEntity
import com.ilham.jpro.lastsubmission.ui.detail.DetailActivity
import com.ilham.jpro.lastsubmission.ui.home.content.favorite.FavoriteViewModel
import com.ilham.jpro.lastsubmission.ui.home.content.movie.MovieAdapter
import com.ilham.jpro.lastsubmission.ui.home.content.movie.MovieCallback
import com.ilham.jpro.lastsubmission.utils.Constants
import com.ilham.jpro.lastsubmission.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.empty_state.*
import kotlinx.android.synthetic.main.fragment_favorite_movie.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class FavoriteMovieFragment : DaggerFragment(), MovieCallback {

    private lateinit var viewModel: FavoriteViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()

        parentFragment?.let {
            viewModel = ViewModelProvider(it, factory)[FavoriteViewModel::class.java]
        }
        observeFavoriteMovies()

    }

    private fun observeFavoriteMovies() {
        viewModel.getListFavoriteMovie().observe(viewLifecycleOwner, Observer {
            if (it != null){
                rv_favorite_movie.adapter?.let {adapter ->
                    when (adapter) {
                        is MovieAdapter -> {
                            if (it.isNullOrEmpty()){
                                rv_favorite_movie.visibility = GONE
                                enableEmptyStateEmptyFavoriteMovie()
                            } else {
                                rv_favorite_movie.visibility = VISIBLE
                                adapter.submitList(it)
                                adapter.notifyDataSetChanged()
                            }
                        }
                    }
                }
            }
        })
    }
    private fun setupRecyclerView() {
        rv_favorite_movie.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MovieAdapter(this@FavoriteMovieFragment)
        }
    }

    private fun enableEmptyStateEmptyFavoriteMovie() {
        img_empty_state.setImageResource(R.drawable.ic_empty_state_favorite)
        img_empty_state.contentDescription =
            resources.getString(R.string.empty_state_desc_no_favorite_item_movie)
        title_empty_state.text = resources.getString(R.string.empty_state_title_no_favorite_item)
        desc_empty_state.text =
            resources.getString(R.string.empty_state_desc_no_favorite_item_movie)
        favorite_movie_empty_state.visibility = VISIBLE
    }

    override fun onItemClicked(data: MovieEntity) {
        startActivity(
            Intent(
                context,
                DetailActivity::class.java
            )
                .putExtra(DetailActivity.EXTRA_DATA, data.movieId)
                .putExtra(DetailActivity.EXTRA_TYPE, Constants.TYPE_MOVIE)
        )
    }

}
