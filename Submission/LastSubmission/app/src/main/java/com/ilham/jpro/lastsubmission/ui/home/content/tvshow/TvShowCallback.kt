package com.ilham.jpro.lastsubmission.ui.home.content.tvshow

import com.ilham.jpro.lastsubmission.data.source.local.entity.TvShowEntity

interface TvShowCallback {
    fun onItemClicked(data: TvShowEntity)
}