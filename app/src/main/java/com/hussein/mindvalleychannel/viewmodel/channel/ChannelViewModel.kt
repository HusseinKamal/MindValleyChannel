package com.hussein.mindvalleychannel.viewmodel.channel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hussein.mindvalleychannel.database.ChannelDao
import com.hussein.mindvalleychannel.model.channel.Channel
import com.hussein.mindvalleychannel.repository.ChannelRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/** This Viewmodel for dealing with Channels data in any other parts in app **/
class ChannelViewModel (val repository: ChannelRepository) : ViewModel(){

    @Inject
    lateinit var channelDao: ChannelDao

    val channel: LiveData<Channel>
        get() = repository.channels

    init {
        viewModelScope.launch {
            repository.getChannels()
        }
    }
    fun getChannels(): LiveData<Channel>
    {
        viewModelScope.launch {
            repository.getChannels()
        }
        return channel
    }
    fun getChannelsDB(): LiveData<Channel>
    {
        viewModelScope.launch {
            repository.getChannelDB()
        }
        return channel
    }
}