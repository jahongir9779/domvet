package com.sablab.domvetdoctor.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sablab.domvetdoctor.cache.db.dao.*
import com.sablab.domvetdoctor.cache.db.entries.*
import com.sablab.domvetdoctor.util.Constants.APP_DATABASE_NAME
import com.sablab.domvetdoctor.util.Constants.APP_DATABASE_VERSION

@Database(
    entities = [EUser::class, ECity::class, ERegion::class, EAnimal::class, EAnimalBreed::class, EPhoto::class, EAnimalType::class],
    version = APP_DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
    abstract fun getCityDao(): CityDao
    abstract fun getAnimalDao(): AnimalDao
    abstract fun getAnimalTypeDao(): AnimalTypeDao
    abstract fun getAnimalBreedDao(): AnimalBreedDao
    abstract fun getPhotoDao(): PhotoDao

    companion object {
        var INSTANCE: AppDatabase? = null

        fun instance(context: Context? = null): AppDatabase {
            return INSTANCE ?: createDatabase(context).also { INSTANCE = it }
        }

        private fun createDatabase(context: Context?): AppDatabase {
            context ?: throw  RuntimeException("database cannot instal. Context get null object")
            return Room.databaseBuilder(context, AppDatabase::class.java, APP_DATABASE_NAME)
                .build()
        }

    }
}
