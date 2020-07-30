package com.sablab.domvetdoctor.data.source

import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.data.repository.DriverPostDataStore
import com.sablab.domvetdoctor.data.repository.DriverPostRemote
import com.sablab.domvetdoctor.data.repository.PlaceDataStore
import com.sablab.domvetdoctor.domain.model.Filter
import com.sablab.domvetdoctor.domain.model.DriverPost
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