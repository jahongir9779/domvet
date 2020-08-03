package com.sablab.domvetdoctor.data.repository

import com.sablab.domvetdoctor.cache.db.entries.EUser
import com.sablab.domvetdoctor.models.City
import com.sablab.domvetdoctor.models.network.NUser
import com.sablab.domvetdoctor.util.ResultWrapper


/**
 * Interface defining methods for the caching of Bufferroos. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */
interface UserCache {

    /**
     * Clear all Bufferoos from the cache.
     */
//    fun clearBufferoos(): Completable

    /**
     * Save a given list of Bufferoos to the cache.
     */
  suspend  fun saveUser(eUser: EUser): NUser

    /**
     * Retrieve a list of Bufferoos, from the cache.
     */
//    fun getBufferoos(): Flowable<List<BufferooEntity>>

    /**
     * Check whether there is a list of Bufferoos stored in the cache.
     *
     * @return true if the list is cached, otherwise false
     */
//    suspend   fun isCached(): ResultWrapper<Boolean>

    /**
     * Set a point in time at when the cache was last updated.
     *
     * @param lastCache the point in time at when the cache was last updated
     */
//    fun setLastCacheTime(lastCache: Long)

    /**
     * Check if the cache is expired.
     *
     * @return true if the cache is expired, otherwise false
     */
//    fun isExpired(): Boolean

}