package com.sablab.domvetdoctor.domain.repository

import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.Place
import com.sablab.domvetdoctor.models.City

interface CitiesRepository {
    suspend fun getAllCities(): ResultWrapper<List<City>>


}