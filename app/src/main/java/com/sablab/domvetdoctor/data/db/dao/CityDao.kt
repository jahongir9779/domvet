package com.sablab.domvetdoctor.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.sablab.domvetdoctor.data.db.dao.BaseDao
import com.sablab.domvetdoctor.data.db.entries.ECity
import com.sablab.domvetdoctor.models.City

@Dao
abstract class CityDao : BaseDao<ECity> {
    @Query("""DELETE FROM ${ECity.TABLE_NAME}""")
    abstract override suspend fun deleteAll()

    @Query("SELECT * FROM ${ECity.TABLE_NAME}")
    abstract fun getCitiesWithLD(): LiveData<List<City>>

    @Query("SELECT * FROM ${ECity.TABLE_NAME}")
    abstract suspend fun getCities(): List<City>
}