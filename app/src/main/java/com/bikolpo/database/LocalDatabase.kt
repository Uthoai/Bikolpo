package com.bikolpo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bikolpo.model.CategoriesResponseItem
import com.bikolpo.model.IndianBrandsResponseItem
import com.bikolpo.utils.Converters

@Database(entities = [CategoriesResponseItem::class,IndianBrandsResponseItem::class], version = 1)
abstract class LocalDatabase():RoomDatabase() {
    abstract val categoriesDao: CategoriesDao
    abstract val indianBrandsDao: IndianBrandsDao


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