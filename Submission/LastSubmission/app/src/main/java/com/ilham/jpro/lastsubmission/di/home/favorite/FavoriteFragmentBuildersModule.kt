package com.ilham.jpro.lastsubmission.di.home.favorite

import com.ilham.jpro.lastsubmission.ui.home.content.favorite.movie.FavoriteMovieFragment
import com.ilham.jpro.lastsubmission.ui.home.content.favorite.tvshow.FavoriteTvShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FavoriteFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeFavoriteMovieFragment() : FavoriteMovieFragment

    @ContributesAndroidInjector
    abstract fun contributeFavoriteTvShowFragment() : FavoriteTvShowFragment
}