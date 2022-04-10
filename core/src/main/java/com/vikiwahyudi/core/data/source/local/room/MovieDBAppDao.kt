package com.vikiwahyudi.core.data.source.local.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDBAppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<com.vikiwahyudi.core.data.source.local.entity.MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShows(tvShows: List<com.vikiwahyudi.core.data.source.local.entity.TvShowEntity>)

    @Query("SELECT * FROM movie_entities")
    fun getAllMovie(): Flow<List<com.vikiwahyudi.core.data.source.local.entity.MovieEntity>>

    @Query("SELECT * FROM tv_show_entities")
    fun getAllTvShow(): Flow<List<com.vikiwahyudi.core.data.source.local.entity.TvShowEntity>>

    @Query("SELECT * FROM movie_entities WHERE isFav = 1")
    fun getFavMovies(): Flow<List<com.vikiwahyudi.core.data.source.local.entity.MovieEntity>>

    @Query("SELECT * FROM tv_show_entities WHERE isFav = 1")
    fun getFavTvShows(): Flow<List<com.vikiwahyudi.core.data.source.local.entity.TvShowEntity>>

    @Query("SELECT * FROM movie_entities WHERE id = :id")
    fun getDetailMovie(id: Int): Flow<com.vikiwahyudi.core.data.source.local.entity.MovieEntity>

    @Query("SELECT * FROM tv_show_entities WHERE id = :id")
    fun getDetailTvShow(id: Int): Flow<com.vikiwahyudi.core.data.source.local.entity.TvShowEntity>

    @Update
    fun updateFavoriteMovie(movieEntity: com.vikiwahyudi.core.data.source.local.entity.MovieEntity)

    @Update
    fun updateFavoriteTvShow(tvShowEntity: com.vikiwahyudi.core.data.source.local.entity.TvShowEntity)
}