package com.bikolpo.view.alternative

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.bikolpo.database.LocalDatabase.Companion.getDatabase
import com.bikolpo.repository.Repository

class AlternativeViewModel(application: Application): AndroidViewModel(application) {
    private val database = getDatabase(application)
    private val repository = Repository(database)

    fun getAlternativesFromDatabase(ids: List<Int>) = repository.getAlternativesFromDatabase(ids)
}