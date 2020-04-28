package com.ilham.jpro.secondsubmission.ui.detail

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ilham.jpro.secondsubmission.R
import com.ilham.jpro.secondsubmission.data.DataModel
import com.ilham.jpro.secondsubmission.utils.Helper.API_IMAGE_ENDPOINT
import com.ilham.jpro.secondsubmission.utils.Helper.ENDPOINT_POSTER_SIZE_W185
import com.ilham.jpro.secondsubmission.utils.Helper.ENDPOINT_POSTER_SIZE_W780
import com.ilham.jpro.secondsubmission.utils.Helper.TYPE_MOVIE
import com.ilham.jpro.secondsubmission.utils.Helper.TYPE_TVSHOW
import com.ilham.jpro.secondsubmission.utils.Helper.setImageWithGlide
import com.ilham.jpro.secondsubmission.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(
            this@DetailActivity,
            factory
        )[DetailViewModel::class.java]

        setupToolbar()

        val id = intent.getIntExtra(EXTRA_DATA, 0)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MOVIE, ignoreCase = true)) {
            setupToolbarTitle(resources.getString(R.string.toolbar_title_detail_movie))

            viewModel.getMovieDetail(id).observe(this, Observer {
                displayData(it)
            })


        } else if (type.equals(TYPE_TVSHOW, ignoreCase = true)) {
            setupToolbarTitle(resources.getString(R.string.toolbar_title_detail_tvshow))

            viewModel.getTvShowDetail(id).observe(this, Observer {
                it?.let {
                    displayData(it)
                }
            })
        }


    }

    private fun displayData(data: DataModel) {
        tv_detail_name.text = data.name
        tv_detail_desc.text = data.desc
        setImageWithGlide(
            this@DetailActivity,
            API_IMAGE_ENDPOINT + ENDPOINT_POSTER_SIZE_W185 + data.poster,
            img_detail_poster
        )

        setImageWithGlide(
            this@DetailActivity,
            API_IMAGE_ENDPOINT + ENDPOINT_POSTER_SIZE_W780 + data.img_preview,
            img_detail_hightlight
        )

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
