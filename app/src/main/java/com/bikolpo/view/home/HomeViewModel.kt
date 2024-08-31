package com.bikolpo.view.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bikolpo.model.CategoriesResponse
import com.bikolpo.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(private val repository: Repository) : ViewModel() {

    private val _categories = MutableLiveData<CategoriesResponse?>()
    val categories: LiveData<CategoriesResponse?> get() = _categories

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = repository.getCategories().body()

                if (response!!.isNotEmpty()){
                    _categories.value = response
                } else {
                    // Handle error
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}