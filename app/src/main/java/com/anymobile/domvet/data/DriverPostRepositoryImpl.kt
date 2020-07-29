package com.anymobile.domvet.data

import com.anymobile.domvet.data.source.DriverPostDataStoreFactory
import com.anymobile.domvet.domain.model.Filter
import com.anymobile.domvet.domain.model.DriverPost
import com.anymobile.domvet.domain.repository.DriverPostRepository
import com.anymobile.domvet.domain.repository.PlaceRepository
import com.anymobile.domvet.util.ErrorWrapper
import com.anymobile.domvet.util.ResultWrapper
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