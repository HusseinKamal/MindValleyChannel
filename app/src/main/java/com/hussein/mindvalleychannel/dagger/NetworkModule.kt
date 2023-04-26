package com.hussein.mindvalleychannel.dagger

import com.hussein.mindvalleychannel.retrofit.RetrofitAPI
import com.hussein.mindvalleychannel.utils.Constant
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule{

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL+Constant.API_EXTENSION_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitAPI(retrofit: Retrofit): RetrofitAPI
    {
        return retrofit.create(RetrofitAPI::class.java)
    }
}