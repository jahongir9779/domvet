package com.sablab.domvetdoctor.cache.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sablab.domvetdoctor.cache.db.entries.EPhoto
import com.sablab.domvetdoctor.models.Photo

@Dao
interface PhotoDao {
    @Insert
    suspend fun insert(vararg obj: EPhoto)

    @Delete
    suspend fun delet(vararg obj: EPhoto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(vararg obj: EPhoto)

    @Query("UPDATE ${EPhoto.TABLE_NAME} SET ${EPhoto.COLUMN_STATE} =:state WHERE ${EPhoto.COLUMN_ID}=:id")
    suspend fun updateStateById(id: String, state: Int)

    @Query("UPDATE ${EPhoto.TABLE_NAME} SET ${EPhoto.COLUMN_STATE} =:state WHERE ${EPhoto.COLUMN_SHA}=:sha")
    suspend fun updateStateBySha(sha: String, state: Int)

    @Query("DELETE FROM ${EPhoto.TABLE_NAME} WHERE ${EPhoto.COLUMN_STATE}=:state")
    suspend fun deleteByState(state: Int)

    @Query(
        """SELECT * FROM ${EPhoto.TABLE_NAME} WHERE 
        ((:state is null )OR(:state is not null and ${EPhoto.COLUMN_STATE}=:state)) 
    """
    )
    fun getPicturesWithLD(state: Int? = null): LiveData<List<Photo>>

    @Query(
        """SELECT * FROM ${EPhoto.TABLE_NAME} WHERE 
        ((:state is null )OR(:state is not null and ${EPhoto.COLUMN_STATE}=:state))
    """
    )
    suspend fun getPictures(state: Int? = null): List<Photo>

    @Query("""SELECT * FROM ${EPhoto.TABLE_NAME} WHERE  ${EPhoto.COLUMN_ID}=:photoId""")
    suspend fun getPicture(photoId: Long): Photo?

    @Query("DELETE FROM ${EPhoto.TABLE_NAME} ")
    suspend fun deleteAll()

    @Query("DELETE FROM ${EPhoto.TABLE_NAME} WHERE  ${EPhoto.COLUMN_ID}=:id")
    suspend fun deleteById(id: Long)
}