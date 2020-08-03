package com.sablab.domvetdoctor.data.source

import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.data.repository.PassengerPostDataStore
import com.sablab.domvetdoctor.data.repository.PassengerPostRemote
import com.sablab.domvetdoctor.data.repository.CityDataStore
import com.sablab.domvetdoctor.domain.model.PassengerPost
import javax.inject.Inject

/**
 * Implementation of the [CityDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class PassengerPostRemoteDataStore @Inject constructor(private val driverPostRemote: PassengerPostRemote) :
    PassengerPostDataStore {

    override suspend fun createPassengerPost(token: String,
                                          post: PassengerPost): ResultWrapper<String> {
        return driverPostRemote.createPassengerPost(token, post)
    }

    override suspend fun deletePassengerPost(token: String,
                                          identifier: String): ResultWrapper<String> {
        return driverPostRemote.deletePassengerPost(token, identifier)

    }

    override suspend fun finishPassengerPost(token: String,
                                          identifier: String): ResultWrapper<String> {
        return driverPostRemote.finishPassengerPost(token, identifier)

    }

    override suspend fun getActivePassengerPosts(token: String,
                                              lang: String): ResultWrapper<List<PassengerPost>> {

        return driverPostRemote.getActivePassengerPosts(token, lang)

    }

    override suspend fun getHistoryPassengerPosts(token: String,
                                               lang: String,
                                               page: Int): ResultWrapper<List<PassengerPost>> {
        return driverPostRemote.getHistoryPassengerPosts(token, lang,page)
    }


}