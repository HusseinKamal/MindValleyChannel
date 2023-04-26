package com.hussein.mindvalleychannel.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hussein.mindvalleychannel.database.ChannelDao
import com.hussein.mindvalleychannel.model.category.Category
import com.hussein.mindvalleychannel.retrofit.RetrofitAPI
import javax.inject.Inject

/** This Repository class for dealing with categories data with CategoryViewModel **/
class CategoryRepository  @Inject constructor(private val retrofitAPI: RetrofitAPI, private val dao: ChannelDao) {
    private val _categories= MutableLiveData<Category>()

    val categories: LiveData<Category>
        get() = _categories

    suspend fun getCategories()
    {
        val result=retrofitAPI.getCategories()
        if(result.isSuccessful && result.body()!=null)
        {
            deleteAllCategories()
            insertRecord(result.body()!!)
            _categories.postValue(result.body())
        }
    }
    //RoomDB
     suspend fun getCategoryDB(){
         val list=dao.getAlCategoriesDB()
        _categories.postValue(list)
     }

     suspend fun insertRecord(category: Category)
     {
         getCategoryDB()
         dao.insertCategoryRecord(category)
     }
     suspend fun deleteAllCategories()
     {
         dao.deleteAllCategories()
     }
}