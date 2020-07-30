package com.sablab.domvetdoctor.data

import com.sablab.domvetdoctor.data.source.DriverPostDataStoreFactory
import com.sablab.domvetdoctor.domain.model.Filter
import com.sablab.domvetdoctor.domain.model.DriverPost
import com.sablab.domvetdoctor.domain.repository.DriverPostRepository
import com.sablab.domvetdoctor.domain.repository.PlaceRepository
import com.sablab.domvetdoctor.util.ErrorWrapper
import com.sablab.domvetdoctor.util.ResultWrapper
import javax.inject.Inject

/**
 * Provides an implementation of the [PlaceRepository] interface for communicating to and from
 * data sources
 */
class DriverPostRepositoryImpl @Inject constructor(private val factoryDriver: DriverPostDataStoreFactory) :
    DriverPostRepository {
    override suspend fun filterDriverPost(token: String,
                                             lang: String,
                                             filter: Filter): ResultWrapper<List<DriverPost>> {

        val response = factoryDriver.retrieveDataStore(false)
            .filterDriverPost(token, lang, filter)

        return when (response) {
            is ErrorWrapper.ResponseError -> response
            is ErrorWrapper.SystemError -> response
            is ResultWrapper.Success -> {
                ResultWrapper.Success(response.value)
            }
            ResultWrapper.InProgress -> ResultWrapper.InProgress
        }
    }

}