package com.hussein.mindvalleychannel.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hussein.mindvalleychannel.database.ChannelDao
import com.hussein.mindvalleychannel.model.MainResponse
import com.hussein.mindvalleychannel.model.category.Category
import com.hussein.mindvalleychannel.model.channel.Channel
import com.hussein.mindvalleychannel.model.episode.Episode
import com.hussein.mindvalleychannel.retrofit.RetrofitAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

/** This Repository class for home data like episodes,channels,categories with your HomeViewModel **/
class HomeRepository @Inject constructor(private val retrofitAPI: RetrofitAPI, private val dao: ChannelDao) {

    private val _home= MutableLiveData<List<MainResponse>>()
    val home: LiveData<List<MainResponse>>
        get() = _home

    suspend fun getHome()
    {
        CoroutineScope(Dispatchers.IO).launch {
            val call1 = async { retrofitAPI.getEpisodes() }.await()
            val call2 = async { retrofitAPI.getChannels() }.await()
            val call3 = async { retrofitAPI.getCategories() }.await()
            if(call1.isSuccessful || call2.isSuccessful || call3.isSuccessful)
            {
                deleteAllHomeData()
                val homeList= getMainHomeList(call1.body()!!,call2.body()!!,call3.body()!!)
                insertRecord(call1.body()!!,call2.body()!!,call3.body()!!)
                _home.postValue(homeList)
            }
        }
    }


    suspend fun getHomeDB()
    {
        if(dao.getEpisodesDB()!=null || dao.getChannelsDB()!=null || dao.getAlCategoriesDB()!=null) {
            val homeList =
                getMainHomeList(dao.getEpisodesDB(), dao.getChannelsDB(), dao.getAlCategoriesDB())
            _home.postValue(homeList)
        }
        else
        {
            getHome()
        }
    }
    suspend fun insertRecord(episode: Episode, channel: Channel, category: Category)
    {
        if(episode!=null) {
            dao.insertEpisodeRecord(episode)
        }
        if(channel!=null) {
            dao.insertChannelRecord(channel)
        }
        if(category!=null) {
            dao.insertCategoryRecord(category)
        }
    }
    suspend fun deleteAllHomeData()
    {
        dao.deleteAllEpisodes()
        dao.deleteAllChannels()
        dao.deleteAllCategories()

    }
    suspend fun getMainHomeList(episodeData: Episode,channelData: Channel,categoryData: Category) : List<MainResponse> {
        val homeList= ArrayList<MainResponse>()
        val episode= MainResponse()
        episode.viewType=MainResponse.VIEW_TYPE_EPISODE
        episode.model=episodeData

        val channel= MainResponse()
        channel.viewType=MainResponse.VIEW_TYPE_CHANNEL
        channel.model=channelData

        val category= MainResponse()
        category.viewType=MainResponse.VIEW_TYPE_CATEGORY
        category.model=categoryData

        homeList.add(0,episode)
        homeList.add(1,channel)
        homeList.add(2,category)
        return homeList
    }
}