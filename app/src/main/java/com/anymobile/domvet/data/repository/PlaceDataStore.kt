package com.anymobile.domvet.data.repository

import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.Place


interface PlaceDataStore {
    suspend fun getPlacesAutocomplete(token: String,lang: String, queryString:String): ResultWrapper<List<Place>>

}