package com.sablab.domvetdoctor.cache

import com.sablab.domvetdoctor.cache.db.AppDatabase
import com.sablab.domvetdoctor.cache.db.entries.EUser
import com.sablab.domvetdoctor.data.repository.UserCache
import com.sablab.domvetdoctor.models.network.NUser
import javax.inject.Inject

/**
 * Cached implementation for retrieving and saving Bufferoo instances. This class implements the
 * [BufferooCache] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class UserCacheImpl @Inject constructor(val database: AppDatabase) :
    UserCache {


    /**
     * Retrieve an instance from the database, used for tests.
     */
//    internal fun getDatabase(): BufferoosDatabase {
//        return bufferoosDatabase
//    }
//
//    /**
//     * Remove all the data from all the tables in the database.
//     */
//    override fun clearBufferoos(): Completable {
//        return Completable.defer {
//            bufferoosDatabase.cachedBufferooDao().clearBufferoos()
//            Completable.complete()
//        }
//    }

//    /**
//     * Save the given list of [BufferooEntity] instances to the database.
//     */
//    override fun saveBufferoos(bufferoos: List<BufferooEntity>): Completable {
//        return Completable.defer {
//            bufferoos.forEach {
//                bufferoosDatabase.cachedBufferooDao().insertBufferoo(
//                    entityMapper.mapToCached(it))
//            }
//            Completable.complete()
//        }
//    }
//
//    /**
//     * Retrieve a list of [BufferooEntity] instances from the database.
//     */
//    override fun getBufferoos(): Flowable<List<BufferooEntity>> {
//        return Flowable.defer {
//            Flowable.just(bufferoosDatabase.cachedBufferooDao().getBufferoos())
//        }.map {
//            it.map { entityMapper.mapFromCached(it) }
//        }
//    }

    /**
     * Check whether there are instances of [CachedBufferoo] stored in the cache.
     */
//    override fun isCached(): Single<Boolean> {
//        return Single.defer {
//            Single.just(bufferoosDatabase.cachedBufferooDao().getBufferoos().isNotEmpty())
//        }
//    }

    override suspend fun saveUser(eUser: EUser): NUser {
        database.getUserDao().insertOrReplace(eUser)
        return EUser.makeNUser(database.getUserDao().getUser()!!)
    }


    /**
     * Check whether the current cached data exceeds the defined [EXPIRATION_TIME] time.
     */
//    override fun isExpired(): Boolean {
//        val currentTime = System.currentTimeMillis()
//        val lastUpdateTime = this.getLastCacheUpdateTimeMillis()
//        return currentTime - lastUpdateTime > EXPIRATION_TIME
//    }

    /**
     * Get in millis, the last time the cache was accessed.
     */
//    private fun getLastCacheUpdateTimeMillis(): Long {
//        return preferencesHelper.lastCacheTime
//    }

}