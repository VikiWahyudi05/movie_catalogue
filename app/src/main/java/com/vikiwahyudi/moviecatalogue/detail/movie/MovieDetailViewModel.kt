package com.vikiwahyudi.moviecatalogue.detail.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.vikiwahyudi.core.domain.model.Movie
import com.vikiwahyudi.core.domain.usecase.movie.MovieUseCase

class MovieDetailViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun getMovieDetail(id: Int) =
        movieUseCase.getDetailMovie(id).asLiveData()

    fun updateFavoriteMovie(movie: Movie, state: Boolean) =
        movieUseCase.updateFavoriteMovie(movie, state)
}