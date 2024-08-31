package com.bikolpo.view.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bikolpo.database.LocalDatabase
import com.bikolpo.database.LocalDatabase.Companion.getDatabase
import com.bikolpo.model.CategoriesResponse
import com.bikolpo.model.CategoriesResponseItem
import com.bikolpo.repository.Repository
import com.bikolpo.service.Network
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val _categories = MutableLiveData<List<CategoriesResponseItem>>()
    val categories: LiveData<List<CategoriesResponseItem>> get() = _categories

    private val database = getDatabase(application)
    private val repository = Repository(database)

    init {
        fetchCategories()
    }

    val categoriesList = repository.getCategoriesFromDatabase()

    private fun fetchCategories() {
        viewModelScope.launch {
            repository.fetchCategories()
            repository.getCategoriesFromDatabase().observeForever { categories ->
                _categories.value = categories
            }
        }
    }

}