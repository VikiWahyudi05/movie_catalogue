package com.vikiwahyudi.core.domain.repository

import com.vikiwahyudi.core.data.Resource
import com.vikiwahyudi.core.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface ITvShowRepository {
    fun getAllTvShow(): Flow<Resource<List<TvShow>>>
    fun getFavTvShows(): Flow<List<TvShow>>
    fun getDetailTvShow(id: Int): Flow<TvShow>
    fun updateFavoriteTvShow(tvShow: TvShow, state: Boolean)
}