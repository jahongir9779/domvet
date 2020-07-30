package com.sablab.domvetdoctor.data.db.dao

import androidx.room.*

@Dao
interface BaseDao<T> {

    @Insert
    suspend fun insert(vararg objects: T)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(vararg objects: T)


    @Delete
    suspend fun delete(vararg objects: T)


    @Update
    suspend fun update(vararg objects: T)

    suspend fun deleteAll()
}