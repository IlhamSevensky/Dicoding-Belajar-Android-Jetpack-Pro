package com.ilham.jpro.lastsubmission.ui.home.content.favorite

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ilham.jpro.lastsubmission.R
import com.ilham.jpro.lastsubmission.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_favorite.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class FavoriteFragment : DaggerFragment() {

    private lateinit var viewModel: FavoriteViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        context?.let { setupViewPager(it) }
        viewModel = ViewModelProvider(this@FavoriteFragment, factory)[FavoriteViewModel::class.java]
    }

    private fun setupViewPager(context: Context) {
        val sectionsPagerAdapter = SectionsPagerAdapter(context, childFragmentManager)
        favorite_view_pager.adapter = sectionsPagerAdapter
        favorite_tab_layout.setupWithViewPager(favorite_view_pager)
    }

}
