package com.vikiwahyudi.moviecatalogue.mainscreen.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.vikiwahyudi.core.domain.usecase.movie.MovieUseCase

class MovieViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val movies = movieUseCase.getAllMovie().asLiveData()
}