package com.sablab.domvetdoctor.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.sablab.domvetdoctor.data.db.dao.BaseDao
import com.sablab.domvetdoctor.data.db.entries.EAnimalBreed
import com.sablab.domvetdoctor.models.AnimalBreed

@Dao
abstract class AnimalBreedDao : BaseDao<EAnimalBreed> {
    @Query("""DELETE FROM ${EAnimalBreed.TABLE_NAME}""")
    abstract override suspend fun deleteAll()

    @Query("SELECT * FROM ${EAnimalBreed.TABLE_NAME}")
    abstract suspend fun getAnimalBreeds(): List<EAnimalBreed>
}