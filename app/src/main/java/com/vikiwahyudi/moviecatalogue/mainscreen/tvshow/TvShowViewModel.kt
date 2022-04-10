package com.vikiwahyudi.moviecatalogue.mainscreen.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.vikiwahyudi.core.domain.usecase.tvshow.TvShowUseCase

class TvShowViewModel(tvShowUseCase: TvShowUseCase) : ViewModel() {
    val tvShows = tvShowUseCase.getAllTvShow().asLiveData()
}