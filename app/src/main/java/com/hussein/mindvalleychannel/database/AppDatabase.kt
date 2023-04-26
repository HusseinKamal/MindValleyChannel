package com.hussein.mindvalleychannel.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hussein.mindvalleychannel.model.category.Category
import com.hussein.mindvalleychannel.model.channel.Channel
import com.hussein.mindvalleychannel.model.episode.Episode

@TypeConverters(RoomTypeConverters::class)
@Database(entities = [(Episode::class),(Channel::class),(Category::class)], exportSchema = false,version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun getShopDao():ChannelDao

    companion object{
        private var db_instance:AppDatabase?=null

        fun getDatabaseInstance(context: Context):AppDatabase{
            if(db_instance==null){
                db_instance= Room.databaseBuilder<AppDatabase>(
                    context.applicationContext,AppDatabase::class.java,"app_db"
                ).allowMainThreadQueries().build()
            }
            return db_instance!!
        }
    }
}