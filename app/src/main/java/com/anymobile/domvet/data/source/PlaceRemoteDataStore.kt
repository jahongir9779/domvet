package com.anymobile.domvet.data.source

import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.data.repository.PlaceDataStore
import com.anymobile.domvet.data.repository.PlaceRemote
import com.anymobile.domvet.domain.model.Place
import javax.inject.Inject

/**
 * Implementation of the [PlaceDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class PlaceRemoteDataStore @Inject constructor(private val placeRemote: PlaceRemote) :
    PlaceDataStore {
    override suspend fun getPlacesAutocomplete(token: String,lang: String,
                                               queryString: String): ResultWrapper<List<Place>> {

        return placeRemote.getPlacesAutocomplete(token, lang,queryString)
    }


}