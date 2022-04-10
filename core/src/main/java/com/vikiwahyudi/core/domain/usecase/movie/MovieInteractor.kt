package com.vikiwahyudi.core.domain.usecase.movie

import com.vikiwahyudi.core.domain.model.Movie
import com.vikiwahyudi.core.domain.repository.IMovieRepository

class MovieInteractor(private val movieRepository: IMovieRepository) : MovieUseCase {

    override fun getAllMovie() = movieRepository.getAllMovie()

    override fun getFavMovies() = movieRepository.getFavMovies()

    override fun getDetailMovie(id: Int) = movieRepository.getDetailMovie(id)

    override fun updateFavoriteMovie(movie: Movie, state: Boolean) =
        movieRepository.updateFavoriteMovie(movie, state)
}