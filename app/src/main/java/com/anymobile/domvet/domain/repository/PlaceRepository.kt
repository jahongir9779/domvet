package com.anymobile.domvet.domain.repository

import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.Place

interface PlaceRepository {

    suspend fun getPlacesAutocomplete(token: String,lang: String, queryString:String): ResultWrapper<List<Place>>


}