package com.bikolpo.view.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bikolpo.database.LocalDatabase.Companion.getDatabase
import com.bikolpo.model.CategoriesResponseItem
import com.bikolpo.model.IndianBrandsResponseItem
import com.bikolpo.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val repository = Repository(database)

    private val _categories = MutableLiveData<List<CategoriesResponseItem>>()
    val categories: LiveData<List<CategoriesResponseItem>> get() = _categories

    private val _indianBrands = MutableLiveData<List<IndianBrandsResponseItem>>()
    val indianBrands: LiveData<List<IndianBrandsResponseItem>> get() = _indianBrands

    init {
        viewModelScope.launch {
            // Fetch categories
            repository.fetchCategories()
            repository.getCategoriesFromDatabase().observeForever { categories ->
                _categories.value = categories
            }

            // Fetch Indian brands
            repository.fetchIndianBrands()
            repository.getIndianBrandsFromDatabase().observeForever { brands ->
                _indianBrands.value = brands
            }

            // Fetch alternatives
            //repository.fetchAlternatives()
        }
    }

    fun filterBrandsByCategory(categoryId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val brands = repository.getBrandsByCategory(categoryId)
            _indianBrands.postValue(brands)
        }
    }

}