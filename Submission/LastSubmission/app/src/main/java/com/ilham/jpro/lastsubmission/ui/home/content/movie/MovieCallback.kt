package com.ilham.jpro.lastsubmission.ui.home.content.movie

import com.ilham.jpro.lastsubmission.data.source.local.entity.MovieEntity

interface MovieCallback {
    fun onItemClicked(data: MovieEntity)
}