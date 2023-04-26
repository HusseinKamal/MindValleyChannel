package com.hussein.mindvalleychannel.viewmodel.episode
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hussein.mindvalleychannel.database.ChannelDao
import com.hussein.mindvalleychannel.model.episode.Episode
import com.hussein.mindvalleychannel.repository.EpisodeRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/** This Viewmodel for dealing with Episodes data in any other parts in app **/
class EpisodeViewModel (val repository: EpisodeRepository) : ViewModel(){

    @Inject
    lateinit var channelDao: ChannelDao

    val episodes: LiveData<Episode>
        get() = repository.episodes

    init {
        viewModelScope.launch {
            repository.getEpisodes()
        }
    }
    fun getEpisode():LiveData<Episode>
    {
        viewModelScope.launch {
            repository.getEpisodes()
        }
        return episodes
    }
    fun getEpisodeDB(): LiveData<Episode>
    {
        viewModelScope.launch {
            repository.getEpisodeDB()
        }
        return episodes
    }
}