package com.ilham.jpro.secondsubmission.ui.home.content.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilham.jpro.secondsubmission.R
import com.ilham.jpro.secondsubmission.data.DataModel
import com.ilham.jpro.secondsubmission.ui.detail.DetailActivity
import com.ilham.jpro.secondsubmission.ui.home.HomeViewModel
import com.ilham.jpro.secondsubmission.ui.home.content.DataAdapter
import com.ilham.jpro.secondsubmission.ui.home.content.DataCallback
import com.ilham.jpro.secondsubmission.utils.Helper.TYPE_MOVIE
import com.ilham.jpro.secondsubmission.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment(), DataCallback {

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupRecyclerView()
        val factory = ViewModelFactory.getInstance()
        activity?.let {
            viewModel = ViewModelProvider(
                it,
                factory
            )[HomeViewModel::class.java]
        }

        viewModel.getListNowPlayingMovies().observe(viewLifecycleOwner, Observer { listMovie ->
            rv_movie.adapter?.let { adapter ->
                when (adapter) {
                    is DataAdapter -> adapter.setData(listMovie)
                }
            }
        })

    }

    private fun setupRecyclerView() {
        rv_movie.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = DataAdapter(this@MovieFragment)
        }
    }

    override fun onItemClicked(data: DataModel) {
        startActivity(
            Intent(
                context,
                DetailActivity::class.java
            )
                .putExtra(DetailActivity.EXTRA_DATA, data.id)
                .putExtra(DetailActivity.EXTRA_TYPE, TYPE_MOVIE)
        )
    }

}
