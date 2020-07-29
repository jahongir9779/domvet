package com.anymobile.domvet.data

import com.anymobile.domvet.data.source.PlaceDataStoreFactory
import com.anymobile.domvet.domain.model.Place
import com.anymobile.domvet.domain.repository.PlaceRepository
import com.anymobile.domvet.util.ErrorWrapper
import com.anymobile.domvet.util.ResultWrapper
import javax.inject.Inject

/**
 * Provides an implementation of the [PlaceRepository] interface for communicating to and from
 * data sources
 */
class PlaceRepositoryImpl @Inject constructor(private val factory: PlaceDataStoreFactory) :
    PlaceRepository {


    override suspend fun getPlacesAutocomplete(token: String, lang: String,
                                               queryString: String): ResultWrapper<List<Place>> {

        val response =
            factory.retrieveDataStore(false).getPlacesAutocomplete(token, lang, queryString)
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