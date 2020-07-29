package com.anymobile.domvet.data.source

import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.data.repository.PassengerPostDataStore
import com.anymobile.domvet.data.repository.PassengerPostRemote
import com.anymobile.domvet.data.repository.PlaceDataStore
import com.anymobile.domvet.domain.model.PassengerPost
import javax.inject.Inject

/**
 * Implementation of the [PlaceDataStore] interface to provide a means of communicating
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