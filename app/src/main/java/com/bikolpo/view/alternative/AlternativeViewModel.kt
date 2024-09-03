package com.bikolpo.view.alternative

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.bikolpo.database.LocalDatabase.Companion.getDatabase
import com.bikolpo.repository.Repository
import kotlinx.coroutines.launch

class AlternativeViewModel(application: Application): AndroidViewModel(application) {
    private val database = getDatabase(application)
    private val repository = Repository(database)

    init {
        viewModelScope.launch {
            // Fetch alternatives
            repository.fetchAlternatives()
        }
    }

    fun getAlternativesFromDatabase(ids: List<Int>) = repository.getAlternativesFromDatabase(ids)
}