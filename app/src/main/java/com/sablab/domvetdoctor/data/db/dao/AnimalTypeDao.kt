package com.sablab.domvetdoctor.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.sablab.domvetdoctor.data.db.dao.BaseDao
import com.sablab.domvetdoctor.data.db.entries.EAnimalType
import com.sablab.domvetdoctor.models.AnimalType

@Dao
abstract class AnimalTypeDao : BaseDao<EAnimalType> {
    @Query("""DELETE FROM ${EAnimalType.TABLE_NAME}""")
    abstract override suspend fun deleteAll()

    @Query("SELECT * FROM ${EAnimalType.TABLE_NAME}")
    abstract suspend fun getAnimalType(): List<EAnimalType>
}