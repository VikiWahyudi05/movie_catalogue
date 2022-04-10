package com.vikiwahyudi.moviecatalogue.detail.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.vikiwahyudi.core.domain.model.TvShow
import com.vikiwahyudi.core.domain.usecase.tvshow.TvShowUseCase

class TvShowDetailViewModel(private val tvShowUseCase: TvShowUseCase) : ViewModel() {
    fun getTvShowDetail(id: Int) =
        tvShowUseCase.getDetailTvShow(id).asLiveData()

    fun updateFavoriteTvShow(tvShow: TvShow, state: Boolean) =
        tvShowUseCase.updateFavoriteTvShow(tvShow, state)
}