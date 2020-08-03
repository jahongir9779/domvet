package com.sablab.domvetdoctor.cache.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.sablab.domvetdoctor.cache.db.entries.EAnimal

@Dao
abstract class AnimalDao : BaseDao<EAnimal> {
    @Query("""DELETE FROM ${EAnimal.TABLE_NAME}""")
    abstract override suspend fun deleteAll()

    @Query(
        """SELECT * FROM ${EAnimal.TABLE_NAME} 
                    WHERE ((:searchText is null)or(:searchText is not null and ${EAnimal.COLUMN_ANIMA_NAME} LIKE :searchText))
                    LIMIT :loadSize OFFSET :page"""
    )
    abstract suspend fun getAllAnimalsSuspend(
        loadSize: Int,
        page: Int,
        searchText: String? = null
    ): List<EAnimal>


    @Query("""SELECT * FROM ${EAnimal.TABLE_NAME} WHERE ${EAnimal.COLUMN_ANIMA_ID}=:animalId""")
    abstract suspend fun getAnimalSuspend(animalId: String): EAnimal?

    @Query("""DELETE FROM ${EAnimal.TABLE_NAME} WHERE ${EAnimal.COLUMN_ANIMA_ID}=:animalId""")
    abstract suspend fun deleteById(animalId: String)

}