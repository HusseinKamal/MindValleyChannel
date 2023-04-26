package com.hussein.mindvalleychannel.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hussein.mindvalleychannel.model.category.Category
import com.hussein.mindvalleychannel.model.channel.Channel
import com.hussein.mindvalleychannel.model.episode.Data
import com.hussein.mindvalleychannel.model.episode.Episode

class RoomTypeConverters{
    //----------------------------Episode
    @TypeConverter
    fun convertEpisodeToJSON(stringList: Episode): String = Gson().toJson(stringList)
    @TypeConverter
    fun convertJSONToEpisode(json: String): Episode = Gson().fromJson(json,Episode::class.java)

    @TypeConverter
    fun convertEpisodeDataToJSON(stringList: Data): String = Gson().toJson(stringList)
    @TypeConverter
    fun convertJSONToEpisodeData(json: String): Data = Gson().fromJson(json,Data::class.java)

    //----------------------------Channel
    @TypeConverter
    fun convertChannelToJSON(channel: Channel): String = Gson().toJson(channel)
    @TypeConverter
    fun convertJSONToChannel(json: String): Channel = Gson().fromJson(json,Channel::class.java)

    @TypeConverter
    fun convertChannelDataToJSON(channel: com.hussein.mindvalleychannel.model.channel.Data): String = Gson().toJson(channel)
    @TypeConverter
    fun convertJSONToChannelData(json: String): com.hussein.mindvalleychannel.model.channel.Data? = Gson().fromJson(json,com.hussein.mindvalleychannel.model.channel.Data::class.java)

    //----------------------------Category
    @TypeConverter
    fun convertCategoryToJSON(category: Category): String = Gson().toJson(category)
    @TypeConverter
    fun convertJSONToCategory(json: String): Category = Gson().fromJson(json,Category::class.java)
    @TypeConverter
    fun convertCategoryDateToJSON(category: com.hussein.mindvalleychannel.model.category.Data): String = Gson().toJson(category)
    @TypeConverter
    fun convertJSONToCategoryDate(json: String): com.hussein.mindvalleychannel.model.category.Data = Gson().fromJson(json,com.hussein.mindvalleychannel.model.category.Data::class.java)
}