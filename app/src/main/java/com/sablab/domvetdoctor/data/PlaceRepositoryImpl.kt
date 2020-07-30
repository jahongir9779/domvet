package com.sablab.domvetdoctor.data

import com.sablab.domvetdoctor.data.source.PlaceDataStoreFactory
import com.sablab.domvetdoctor.domain.model.Place
import com.sablab.domvetdoctor.domain.repository.PlaceRepository
import com.sablab.domvetdoctor.util.ErrorWrapper
import com.sablab.domvetdoctor.util.ResultWrapper
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