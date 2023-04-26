package com.hussein.mindvalleychannel.viewmodel.channel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hussein.mindvalleychannel.repository.ChannelRepository
import javax.inject.Inject

class ChannelViewModelFactory @Inject constructor(private val repository: ChannelRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ChannelViewModel(repository) as T
    }
}