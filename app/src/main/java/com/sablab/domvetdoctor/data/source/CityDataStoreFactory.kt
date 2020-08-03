package com.sablab.domvetdoctor.data.source

import com.sablab.domvetdoctor.data.repository.CityDataStore
import javax.inject.Inject

/**
 * Create an instance of a BufferooDataStore
 */
open class CityDataStoreFactory @Inject constructor(
//        private val placeCache: BufferooCache,
//        private val placeCacheDataStore: BufferooCacheDataStore,
        private val placeRemoteDataStore: CityRemoteDataStore) {

    /**
     * Returns a DataStore based on whether or not there is content in the cache and the cache
     * has not expired
     */
    open fun retrieveDataStore(isCached: Boolean): CityDataStore {
//        if (isCached && !placeCache.isExpired()) {
//            return retrieveCacheDataStore()
//        }
        return retrieveRemoteDataStore()
    }

//    /**
//     * Return an instance of the Cache Data Store
//     */
//    open fun retrieveCacheDataStore(): PlaceDataStore {
//        return placeCacheDataStore
//    }

    /**
     * Return an instance of the Remote Data Store
     */
    open fun retrieveRemoteDataStore(): CityDataStore {
        return placeRemoteDataStore
    }

}