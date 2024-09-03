package com.bikolpo.app

import android.app.Application
import com.bikolpo.database.LocalDatabase
import com.bikolpo.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BikolpoApp: Application() {

    private val applicationScope = CoroutineScope(Dispatchers.IO)

    private val database = LocalDatabase.getDatabase(this)
    private val repository = Repository(database)

    override fun onCreate() {
        super.onCreate()
        //delayedInit()
    }

    private fun delayedInit() {
        applicationScope.launch {
            repository.fetchCategories()
            repository.fetchIndianBrands()
            repository.fetchAlternatives()
        }
    }
}