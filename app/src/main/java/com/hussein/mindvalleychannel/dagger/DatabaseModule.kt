package com.hussein.mindvalleychannel.dagger

import android.content.Context
import com.hussein.mindvalleychannel.database.AppDatabase
import com.hussein.mindvalleychannel.database.ChannelDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule (/*val application: Application*/)  {

    @Singleton
    @Provides
    fun getShopDao(appDatabase: AppDatabase): ChannelDao {
        return appDatabase.getShopDao()
    }

    @Singleton
    @Provides
    fun getRoomDBInstance(context: Context): AppDatabase {
        return AppDatabase.getDatabaseInstance(context)
    }

  /*  @Singleton
    @Provides
    fun provideAppContext(): Context {
        return application.applicationContext
    }*/
}