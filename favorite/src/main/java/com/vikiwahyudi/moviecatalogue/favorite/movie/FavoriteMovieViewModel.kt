package com.vikiwahyudi.moviecatalogue.favorite.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.vikiwahyudi.core.domain.usecase.movie.MovieUseCase

class FavoriteMovieViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favMovies = movieUseCase.getFavMovies().asLiveData()
}