package com.sablab.domvetdoctor.data.source

import com.sablab.domvetdoctor.data.repository.UserDataStore
import javax.inject.Inject

/**
 * Create an instance of a BufferooDataStore
 */
open class UserDataStoreFactory @Inject constructor(
//        private val userCache: BufferooCache,
    private val userCacheDataStore: UserCacheDataStore,
    private val userRemoteDataStore: UserRemoteDataStore) {

    /**
     * Returns a DataStore based on whether or not there is content in the cache and the cache
     * has not expired
     */
    open fun retrieveDataStore(isCached: Boolean): UserDataStore {
        return if (isCached) userCacheDataStore else userRemoteDataStore
    }

//    open fun retrieveDataStore(isCached: Boolean): BufferooDataStore {
//        if (isCached && !bufferooCache.isExpired()) {
//            return retrieveCacheDataStore()
//        }
//        return retrieveRemoteDataStore()
//    }


//    /**
//     * Return an instance of the Cache Data Store
//     */
//    open fun retrieveCacheDataStore(): UserDataStore {
//        return userCacheDataStore
//    }
//
//    /**
//     * Return an instance of the Remote Data Store
//     */
//    open fun retrieveRemoteDataStore(): UserDataStore {
//        return userRemoteDataStore
//    }

}