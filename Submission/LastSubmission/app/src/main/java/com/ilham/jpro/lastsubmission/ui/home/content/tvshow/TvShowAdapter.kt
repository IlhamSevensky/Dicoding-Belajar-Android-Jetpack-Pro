package com.ilham.jpro.lastsubmission.ui.home.content.tvshow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ilham.jpro.lastsubmission.BuildConfig
import com.ilham.jpro.lastsubmission.R
import com.ilham.jpro.lastsubmission.data.source.local.entity.TvShowEntity
import com.ilham.jpro.lastsubmission.utils.Constants
import com.ilham.jpro.lastsubmission.utils.loadFromUrl
import kotlinx.android.synthetic.main.item_row_data.view.*

class TvShowAdapter (private val callback: TvShowCallback) :
    PagedListAdapter<TvShowEntity, TvShowAdapter.ListViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.tvShowId == newItem.tvShowId
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: TvShowEntity) {
            with(itemView) {
                data.poster?.let {
                    img_data.loadFromUrl(BuildConfig.BASE_URL_IMAGE_TMDB + Constants.ENDPOINT_POSTER_SIZE_W185 + it)
                }
                tv_data_title.text = data.name
                tv_data_desc.text = data.desc
                card_item.setOnClickListener {
                    callback.onItemClicked(data)
                }

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_data, parent, false)
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

}