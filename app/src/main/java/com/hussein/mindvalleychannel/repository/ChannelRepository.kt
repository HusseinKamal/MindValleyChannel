package com.hussein.mindvalleychannel.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hussein.mindvalleychannel.database.ChannelDao
import com.hussein.mindvalleychannel.model.channel.Channel
import com.hussein.mindvalleychannel.retrofit.RetrofitAPI
import javax.inject.Inject

/** This Repository class for dealing with channels(series-courses) data with ChannelViewModel **/
class ChannelRepository @Inject constructor(private val retrofitAPI: RetrofitAPI, private val dao: ChannelDao) {
    private val _channels= MutableLiveData<Channel>()
    val channels: LiveData<Channel>
        get() = _channels

    suspend fun getChannels()
    {
        val result=retrofitAPI.getChannels()
        if(result.isSuccessful && result.body()!=null)
        {
            deleteAllProducts()
            insertRecord(result.body()!!)
            _channels.postValue(result.body())
        }
    }
    //RoomDB
     suspend fun getChannelDB(){
         val list=dao.getChannelsDB()
        _channels.postValue(list)
     }

     suspend fun insertRecord(channel: Channel)
     {
         getChannelDB()
         dao.insertChannelRecord(channel)
     }
     suspend fun deleteAllProducts()
     {
         dao.deleteAllChannels()
     }
}