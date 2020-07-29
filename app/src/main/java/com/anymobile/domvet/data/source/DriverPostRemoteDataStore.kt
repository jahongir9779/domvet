package com.anymobile.domvet.data.source

import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.data.repository.DriverPostDataStore
import com.anymobile.domvet.data.repository.DriverPostRemote
import com.anymobile.domvet.data.repository.PlaceDataStore
import com.anymobile.domvet.domain.model.Filter
import com.anymobile.domvet.domain.model.DriverPost
import javax.inject.Inject

/**
 * Implementation of the [PlaceDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class DriverPostRemoteDataStore @Inject constructor(private val passengerPostRemote: DriverPostRemote) :
    DriverPostDataStore {

    override suspend fun filterDriverPost(token: String,
                                             lang: String,
                                             filter: Filter): ResultWrapper<List<DriverPost>> {

        return passengerPostRemote.filterDriverPost(token, lang, filter)
    }

}