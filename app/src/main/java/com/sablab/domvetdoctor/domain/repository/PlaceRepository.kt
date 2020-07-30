package com.sablab.domvetdoctor.domain.repository

import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.Place

interface PlaceRepository {

    suspend fun getPlacesAutocomplete(token: String,lang: String, queryString:String): ResultWrapper<List<Place>>


}