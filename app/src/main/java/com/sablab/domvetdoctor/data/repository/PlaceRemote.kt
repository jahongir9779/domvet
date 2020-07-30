package com.sablab.domvetdoctor.data.repository

import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.Place

interface PlaceRemote {

   suspend fun getPlacesAutocomplete(token: String,lang: String, queryString:String): ResultWrapper<List<Place>>

}