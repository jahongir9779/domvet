package com.sablab.domvetdoctor.cache.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.sablab.domvetdoctor.cache.db.entries.EAnimalType

@Dao
abstract class AnimalTypeDao : BaseDao<EAnimalType> {
    @Query("""DELETE FROM ${EAnimalType.TABLE_NAME}""")
    abstract override suspend fun deleteAll()

    @Query("SELECT * FROM ${EAnimalType.TABLE_NAME}")
    abstract suspend fun getAnimalType(): List<EAnimalType>
}