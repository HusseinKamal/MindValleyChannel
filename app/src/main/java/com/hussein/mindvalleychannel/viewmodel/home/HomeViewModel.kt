package com.hussein.mindvalleychannel.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hussein.mindvalleychannel.database.ChannelDao
import com.hussein.mindvalleychannel.model.MainResponse
import com.hussein.mindvalleychannel.repository.HomeRepository
import kotlinx.coroutines.*
import javax.inject.Inject

/** This Viewmodel for dealing with Home data like Episodes,Channels and Categories etc **/
class HomeViewModel (val homeRepo: HomeRepository) : ViewModel(){

    @Inject
    lateinit var channelDao: ChannelDao

    val homeData: LiveData<List<MainResponse>>
        get() = homeRepo.home

    fun getHome():LiveData<List<MainResponse>>{
        try {
           viewModelScope.launch {
                homeRepo.getHome()
            }
        }
        catch (exception: Exception) {
            exception.printStackTrace()
        }
        return homeData
    }
    fun getHomeDB():LiveData<List<MainResponse>>{
        try {
            viewModelScope.launch {
                homeRepo.getHomeDB()
            }
        }
        catch (exception: Exception) {
            exception.printStackTrace()
        }
        return homeData
    }
}