package com.sablab.domvetdoctor.data.source

import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.data.repository.PlaceDataStore
import com.sablab.domvetdoctor.data.repository.PlaceRemote
import com.sablab.domvetdoctor.domain.model.Place
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