package com.vikiwahyudi.moviecatalogue.favorite

import com.vikiwahyudi.moviecatalogue.favorite.movie.FavoriteMovieViewModel
import com.vikiwahyudi.moviecatalogue.favorite.tvshow.FavoriteTvShowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { FavoriteMovieViewModel(get()) }
    viewModel { FavoriteTvShowViewModel(get()) }
}
