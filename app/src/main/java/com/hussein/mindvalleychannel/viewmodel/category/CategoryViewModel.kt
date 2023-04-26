package com.hussein.mindvalleychannel.viewmodel.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hussein.mindvalleychannel.database.ChannelDao
import com.hussein.mindvalleychannel.model.category.Category
import com.hussein.mindvalleychannel.repository.CategoryRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/** This Viewmodel for dealing with categories data in any other parts in app **/
class CategoryViewModel (val repository: CategoryRepository) : ViewModel(){

    @Inject
    lateinit var channelDao: ChannelDao

    val category: LiveData<Category>
        get() = repository.categories

    fun getCategories(): LiveData<Category>
    {
        viewModelScope.launch {
            repository.getCategories()
        }
        return category
    }
    fun getCategoriesDB(): LiveData<Category>
    {
        viewModelScope.launch {
            repository.getCategoryDB()
        }
        return category
    }
}