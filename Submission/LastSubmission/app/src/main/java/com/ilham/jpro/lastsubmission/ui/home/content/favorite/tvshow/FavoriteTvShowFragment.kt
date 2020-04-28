package com.ilham.jpro.lastsubmission.ui.home.content.favorite.tvshow

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
import com.ilham.jpro.lastsubmission.data.source.local.entity.TvShowEntity
import com.ilham.jpro.lastsubmission.ui.detail.DetailActivity
import com.ilham.jpro.lastsubmission.ui.home.content.favorite.FavoriteViewModel
import com.ilham.jpro.lastsubmission.ui.home.content.tvshow.TvShowAdapter
import com.ilham.jpro.lastsubmission.ui.home.content.tvshow.TvShowCallback
import com.ilham.jpro.lastsubmission.utils.Constants
import com.ilham.jpro.lastsubmission.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.empty_state.*
import kotlinx.android.synthetic.main.fragment_favorite_tv_show.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class FavoriteTvShowFragment : DaggerFragment(), TvShowCallback {

    private lateinit var viewModel: FavoriteViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()

        parentFragment?.let {
            viewModel = ViewModelProvider(it, factory)[FavoriteViewModel::class.java]
        }
        observeFavoriteTvShow()

    }

    private fun observeFavoriteTvShow() {
        viewModel.getListFavoriteTvShow().observe(viewLifecycleOwner, Observer {
            if (it != null){
                rv_favorite_tvshow.adapter?.let {adapter ->
                    when (adapter) {
                        is TvShowAdapter -> {
                            if (it.isNullOrEmpty()){
                                rv_favorite_tvshow.visibility = GONE
                                enableEmptyStateEmptyFavoriteTvShow()
                            } else {
                                rv_favorite_tvshow.visibility = VISIBLE
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
        rv_favorite_tvshow.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TvShowAdapter(this@FavoriteTvShowFragment)
        }
    }

    private fun enableEmptyStateEmptyFavoriteTvShow() {
        img_empty_state.setImageResource(R.drawable.ic_empty_state_favorite)
        img_empty_state.contentDescription =
            resources.getString(R.string.empty_state_desc_no_favorite_item_tvshow)
        title_empty_state.text = resources.getString(R.string.empty_state_title_no_favorite_item)
        desc_empty_state.text =
            resources.getString(R.string.empty_state_desc_no_favorite_item_tvshow)
        favorite_tvshow_empty_state.visibility = VISIBLE
    }

    override fun onItemClicked(data: TvShowEntity) {
        startActivity(
            Intent(
                context,
                DetailActivity::class.java
            )
                .putExtra(DetailActivity.EXTRA_DATA, data.tvShowId)
                .putExtra(DetailActivity.EXTRA_TYPE, Constants.TYPE_TVSHOW)
        )
    }

}
