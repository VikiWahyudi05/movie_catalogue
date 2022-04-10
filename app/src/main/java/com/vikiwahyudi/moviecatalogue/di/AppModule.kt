package com.vikiwahyudi.moviecatalogue.di

import com.vikiwahyudi.core.domain.usecase.movie.MovieInteractor
import com.vikiwahyudi.core.domain.usecase.movie.MovieUseCase
import com.vikiwahyudi.core.domain.usecase.tvshow.TvShowInteractor
import com.vikiwahyudi.core.domain.usecase.tvshow.TvShowUseCase
import com.vikiwahyudi.moviecatalogue.detail.movie.MovieDetailViewModel
import com.vikiwahyudi.moviecatalogue.detail.tvshow.TvShowDetailViewModel
import com.vikiwahyudi.moviecatalogue.mainscreen.movie.MovieViewModel
import com.vikiwahyudi.moviecatalogue.mainscreen.tvshow.TvShowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
    factory<TvShowUseCase> { TvShowInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }

    viewModel { TvShowViewModel(get()) }
    viewModel { TvShowDetailViewModel(get()) }
}
