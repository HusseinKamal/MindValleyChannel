package com.hussein.mindvalleychannel.viewmodel.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hussein.mindvalleychannel.repository.CategoryRepository
import javax.inject.Inject

class CategoryViewModelFactory @Inject constructor(private val repository: CategoryRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CategoryViewModel(repository) as T
    }
}