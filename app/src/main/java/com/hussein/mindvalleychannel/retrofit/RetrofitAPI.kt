package com.hussein.mindvalleychannel.retrofit
import com.hussein.mindvalleychannel.model.category.Category
import com.hussein.mindvalleychannel.model.channel.Channel
import com.hussein.mindvalleychannel.model.episode.Episode
import com.hussein.mindvalleychannel.utils.Constant
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitAPI {
    @GET(Constant.NEW_EPISODES_URL)
    suspend fun getEpisodes(): Response<Episode>

    @GET(Constant.CHANNELS_URL)
    suspend fun getChannels(): Response<Channel>

    @GET(Constant.CATEGORIES_URL)
    suspend fun getCategories(): Response<Category>
}