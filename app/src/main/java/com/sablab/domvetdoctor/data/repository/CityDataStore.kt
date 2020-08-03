package com.sablab.domvetdoctor.data.repository

import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.Place
import com.sablab.domvetdoctor.models.City


interface CityDataStore {
    suspend fun getAllCities(): ResultWrapper<List<City>>
}