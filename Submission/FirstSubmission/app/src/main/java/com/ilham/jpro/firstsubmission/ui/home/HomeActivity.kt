package com.ilham.jpro.firstsubmission.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ilham.jpro.firstsubmission.R
import com.ilham.jpro.firstsubmission.ui.home.content.movie.MovieFragment
import com.ilham.jpro.firstsubmission.ui.home.content.tvshow.TvShowFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewModel = ViewModelProvider(
            this@HomeActivity,
            ViewModelProvider.NewInstanceFactory()
        )[HomeViewModel::class.java]

        setupToolbar()
        setupBottomNavBar()
    }

    private fun setupToolbar() {
        setSupportActionBar(main_toolbar)
        supportActionBar?.elevation = 8F
    }

    private fun setupBottomNavBar() {
        val movieFragment = MovieFragment()
        val tvShowFragment = TvShowFragment()

        setActiveFragment(movieFragment, resources.getString(R.string.tab_title_movie))

        bottom_navbar.setNavigationChangeListener { view, _ ->
            when (view.id) {
                R.id.nav_movie -> setActiveFragment(
                    movieFragment,
                    resources.getString(R.string.tab_title_movie)
                )
                R.id.nav_tvshow -> setActiveFragment(
                    tvShowFragment,
                    resources.getString(R.string.tab_title_tvshow)
                )
            }
        }
    }

    private fun setActiveFragment(fragment: Fragment, title: String) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().apply {
            replace(R.id.container_main_fragment, fragment)
        }.commit()

        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}
