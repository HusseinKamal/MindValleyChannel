package com.hussein.mindvalleychannel.viewmodel.episode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hussein.mindvalleychannel.repository.EpisodeRepository
import javax.inject.Inject

class EpisodeViewModelFactory@Inject constructor(private val repository: EpisodeRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EpisodeViewModel(repository) as T
    }
}