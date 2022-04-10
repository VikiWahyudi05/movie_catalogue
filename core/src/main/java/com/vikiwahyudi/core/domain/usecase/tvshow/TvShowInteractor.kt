package com.vikiwahyudi.core.domain.usecase.tvshow

import com.vikiwahyudi.core.domain.model.TvShow
import com.vikiwahyudi.core.domain.repository.ITvShowRepository

class TvShowInteractor(private val tvShowRepository: ITvShowRepository) : TvShowUseCase {
    override fun getAllTvShow() = tvShowRepository.getAllTvShow()

    override fun getFavTvShows() = tvShowRepository.getFavTvShows()

    override fun getDetailTvShow(id: Int) = tvShowRepository.getDetailTvShow(id)

    override fun updateFavoriteTvShow(tvShow: TvShow, state: Boolean) =
        tvShowRepository.updateFavoriteTvShow(tvShow, state)
}