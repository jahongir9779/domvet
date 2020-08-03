package com.sablab.domvetdoctor.cache.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.sablab.domvetdoctor.cache.db.entries.EAnimalBreed

@Dao
abstract class AnimalBreedDao : BaseDao<EAnimalBreed> {
    @Query("""DELETE FROM ${EAnimalBreed.TABLE_NAME}""")
    abstract override suspend fun deleteAll()

    @Query("SELECT * FROM ${EAnimalBreed.TABLE_NAME}")
    abstract suspend fun getAnimalBreeds(): List<EAnimalBreed>
}