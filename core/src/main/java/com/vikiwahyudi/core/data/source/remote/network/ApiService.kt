package com.vikiwahyudi.core.data.source.remote.network

import com.vikiwahyudi.core.data.source.remote.response.movie.MoviesResponse
import com.vikiwahyudi.core.data.source.remote.response.tvshow.TvShowsResponse
import com.vikiwahyudi.core.utils.NetworkInfo.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String = API_KEY
    ): MoviesResponse

    @GET("discover/tv")
    suspend fun getTvShows(
        @Query("api_key") apiKey: String = API_KEY
    ): TvShowsResponse
}