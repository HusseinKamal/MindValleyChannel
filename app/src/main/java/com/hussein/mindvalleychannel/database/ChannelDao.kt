package com.hussein.mindvalleychannel.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hussein.mindvalleychannel.model.category.Category
import com.hussein.mindvalleychannel.model.channel.Channel
import com.hussein.mindvalleychannel.model.episode.Episode

@Dao
interface ChannelDao {
    //Episodes
    @Query("SELECT * FROM episode")
    fun getEpisodesDB(): Episode

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEpisodeRecord(episode: Episode)

    @Query("DELETE FROM episode")
    fun deleteAllEpisodes()

    //Channel
    @Query("SELECT * FROM channel")
    fun getChannelsDB(): Channel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertChannelRecord(channel: Channel)

    @Query("DELETE FROM channel")
    fun deleteAllChannels()

    //Category
    @Query("SELECT * FROM category")
    fun getAlCategoriesDB(): Category

    @Query("SELECT * FROM category WHERE id=:idValue")
    fun getCategoryRecord(idValue:Int): Category

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategoryRecord(category: Category)

    @Query("DELETE FROM category")
    fun deleteAllCategories()

    @Query("DELETE FROM category WHERE id=:idValue")
    fun deleteCategoryRecord(idValue:Int)

}