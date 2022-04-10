package com.vikiwahyudi.core.utils

import com.vikiwahyudi.core.data.source.remote.response.movie.MovieResponse
import com.vikiwahyudi.core.data.source.remote.response.tvshow.TvShowResponse
import com.vikiwahyudi.core.domain.model.Movie
import com.vikiwahyudi.core.domain.model.TvShow

object DataMapper {
    fun mapMovieResponsesToEntities(input: List<MovieResponse>): List<com.vikiwahyudi.core.data.source.local.entity.MovieEntity> {
        val movieList = ArrayList<com.vikiwahyudi.core.data.source.local.entity.MovieEntity>()
        input.map {
            val movie = com.vikiwahyudi.core.data.source.local.entity.MovieEntity(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                voteAverage = it.voteAverage,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                isFav = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapTvShowResponsesToEntities(input: List<TvShowResponse>): List<com.vikiwahyudi.core.data.source.local.entity.TvShowEntity> {
        val tvShowList = ArrayList<com.vikiwahyudi.core.data.source.local.entity.TvShowEntity>()
        input.map {
            val tvShow = com.vikiwahyudi.core.data.source.local.entity.TvShowEntity(
                id = it.id,
                name = it.name,
                firstAirDate = it.firstAirDate,
                voteAverage = it.voteAverage,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                isFav = false
            )
            tvShowList.add(tvShow)
        }
        return tvShowList
    }

    fun mapMovieEntitiesToDomain(input: List<com.vikiwahyudi.core.data.source.local.entity.MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                voteAverage = it.voteAverage,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                isFav = it.isFav
            )
        }

    fun mapTvShowEntitiesToDomain(input: List<com.vikiwahyudi.core.data.source.local.entity.TvShowEntity>): List<TvShow> =
        input.map {
            TvShow(
                id = it.id,
                name = it.name,
                firstAirDate = it.firstAirDate,
                voteAverage = it.voteAverage,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                isFav = it.isFav
            )
        }

    fun mapMovieDomainToEntity(input: Movie) =
        com.vikiwahyudi.core.data.source.local.entity.MovieEntity(
            id = input.id,
            title = input.title,
            releaseDate = input.releaseDate,
            voteAverage = input.voteAverage,
            overview = input.overview,
            popularity = input.popularity,
            posterPath = input.posterPath,
            isFav = input.isFav
        )

    fun mapTvShowDomainToEntity(input: TvShow) =
        com.vikiwahyudi.core.data.source.local.entity.TvShowEntity(
            id = input.id,
            name = input.name,
            firstAirDate = input.firstAirDate,
            voteAverage = input.voteAverage,
            overview = input.overview,
            popularity = input.popularity,
            posterPath = input.posterPath,
            isFav = input.isFav
        )

    fun mapMovieEntityToDomain(input: com.vikiwahyudi.core.data.source.local.entity.MovieEntity) =
        Movie(
            id = input.id,
            title = input.title,
            releaseDate = input.releaseDate,
            voteAverage = input.voteAverage,
            overview = input.overview,
            popularity = input.popularity,
            posterPath = input.posterPath,
            isFav = input.isFav
        )

    fun mapTvShowEntityToDomain(input: com.vikiwahyudi.core.data.source.local.entity.TvShowEntity) =
        TvShow(
            id = input.id,
            name = input.name,
            firstAirDate = input.firstAirDate,
            voteAverage = input.voteAverage,
            overview = input.overview,
            popularity = input.popularity,
            posterPath = input.posterPath,
            isFav = input.isFav
        )
}