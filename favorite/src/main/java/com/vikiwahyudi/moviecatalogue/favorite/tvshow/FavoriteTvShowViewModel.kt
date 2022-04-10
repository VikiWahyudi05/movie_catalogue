package com.vikiwahyudi.moviecatalogue.favorite.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.vikiwahyudi.core.domain.usecase.tvshow.TvShowUseCase

class FavoriteTvShowViewModel(tvShowUseCase: TvShowUseCase) : ViewModel() {
    val favTvShows = tvShowUseCase.getFavTvShows().asLiveData()
}