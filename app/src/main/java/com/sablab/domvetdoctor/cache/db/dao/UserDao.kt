package com.sablab.domvetdoctor.cache.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.sablab.domvetdoctor.cache.db.entries.EUser
import com.sablab.domvetdoctor.models.User

@Dao
abstract class UserDao : BaseDao<EUser> {
    @Query("""DELETE FROM ${EUser.TABLE_NAME}""")
    abstract override suspend fun deleteAll()

    @Query("SELECT * FROM ${EUser.TABLE_NAME} where ${EUser.COLUMN_USER_LOCAL_STATE} LIKE '${EUser.USER_STATE_ACTIVE}' LIMIT 1")
    abstract suspend fun getUser(): User?

    @Query("SELECT * FROM ${EUser.TABLE_NAME} LIMIT 1")
    abstract suspend fun getUserP_A(): User?
}