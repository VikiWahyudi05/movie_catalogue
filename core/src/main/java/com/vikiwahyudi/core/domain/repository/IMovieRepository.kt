package com.vikiwahyudi.core.domain.repository

import com.vikiwahyudi.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getAllMovie(): Flow<com.vikiwahyudi.core.data.Resource<List<Movie>>>
    fun getFavMovies(): Flow<List<Movie>>
    fun getDetailMovie(id: Int): Flow<Movie>
    fun updateFavoriteMovie(movie: Movie, state: Boolean)
}