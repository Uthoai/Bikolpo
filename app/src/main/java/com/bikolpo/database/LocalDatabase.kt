package com.bikolpo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bikolpo.database.dao.AlternativeDao
import com.bikolpo.database.dao.CategoriesDao
import com.bikolpo.database.dao.IndianBrandsDao
import com.bikolpo.model.AlternativesResponseItem
import com.bikolpo.model.CategoriesResponseItem
import com.bikolpo.model.IndianBrandsResponseItem

@Database(
    entities = [
        CategoriesResponseItem::class,
        IndianBrandsResponseItem::class,
        AlternativesResponseItem::class
    ],
    version = 1
)
abstract class LocalDatabase() : RoomDatabase() {
    abstract val categoriesDao: CategoriesDao
    abstract val indianBrandsDao: IndianBrandsDao
    abstract val alternativeDao: AlternativeDao

    companion object {
        @Volatile
        private var INSTANCE: LocalDatabase? = null

        fun getDatabase(context: Context): LocalDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LocalDatabase::class.java,
                    "local_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}