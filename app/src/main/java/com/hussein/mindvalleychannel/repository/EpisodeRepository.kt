package com.hussein.mindvalleychannel.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hussein.mindvalleychannel.database.ChannelDao
import com.hussein.mindvalleychannel.model.episode.Episode
import com.hussein.mindvalleychannel.retrofit.RetrofitAPI
import javax.inject.Inject

/** This Repository class for dealing episodes data with EpisodeViewModel **/
class EpisodeRepository @Inject constructor(private val retrofitAPI: RetrofitAPI, private val dao: ChannelDao) {
    private val _episodes= MutableLiveData<Episode>()
    val episodes: LiveData<Episode>
        get() = _episodes

    suspend fun getEpisodes()
    {
        val result=retrofitAPI.getEpisodes()
        if(result.isSuccessful && result.body()!=null)
        {
            deleteAllEpisodes()
            insertRecord(result.body()!!)
            _episodes.postValue(result.body())
        }
    }
    //RoomDB
    suspend fun getEpisodeDB(){
        val list=dao.getEpisodesDB()
        _episodes.postValue(list)
    }

    suspend fun insertRecord(episode: Episode)
    {
        getEpisodeDB()
        dao.insertEpisodeRecord(episode)
    }
    suspend fun deleteAllEpisodes()
    {
        dao.deleteAllEpisodes()
    }
}