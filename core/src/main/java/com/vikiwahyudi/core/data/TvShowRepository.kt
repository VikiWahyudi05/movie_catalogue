package com.vikiwahyudi.core.data

import com.vikiwahyudi.core.data.source.local.LocalDataSource
import com.vikiwahyudi.core.data.source.remote.RemoteDataSource
import com.vikiwahyudi.core.data.source.remote.network.ApiResponse
import com.vikiwahyudi.core.data.source.remote.response.tvshow.TvShowResponse
import com.vikiwahyudi.core.domain.model.TvShow
import com.vikiwahyudi.core.domain.repository.ITvShowRepository
import com.vikiwahyudi.core.utils.AppExecutors
import com.vikiwahyudi.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TvShowRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ITvShowRepository {
    override fun getAllTvShow(): Flow<Resource<List<TvShow>>> =
        object :
            com.vikiwahyudi.core.data.NetworkBoundResource<List<TvShow>, List<TvShowResponse>>() {
            override fun loadFromDB(): Flow<List<TvShow>> {
                return localDataSource.getAllTvShow().map {
                    DataMapper.mapTvShowEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<TvShow>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getTvShows()

            override suspend fun saveCallResult(data: List<TvShowResponse>) {
                val tvShowList = DataMapper.mapTvShowResponsesToEntities(data)
                localDataSource.insertTvShows(tvShowList)
            }
        }.asFlow()

    override fun getFavTvShows(): Flow<List<TvShow>> {
        return localDataSource.getFavTvShows().map {
            DataMapper.mapTvShowEntitiesToDomain(it)
        }
    }

    override fun getDetailTvShow(id: Int): Flow<TvShow> {
        return localDataSource.getDetailTvShow(id).map {
            DataMapper.mapTvShowEntityToDomain(it)
        }
    }

    override fun updateFavoriteTvShow(tvShow: TvShow, state: Boolean) {
        val tvShowEntity = DataMapper.mapTvShowDomainToEntity(tvShow)
        appExecutors.diskIO().execute {
            localDataSource.updateFavoriteTvShow(tvShowEntity, state)
        }
    }
}