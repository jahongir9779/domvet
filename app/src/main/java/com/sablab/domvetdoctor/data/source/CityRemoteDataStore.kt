package com.sablab.domvetdoctor.data.source

import com.sablab.domvetdoctor.data.repository.CityDataStore
import com.sablab.domvetdoctor.data.repository.CityRemote
import com.sablab.domvetdoctor.models.City
import com.sablab.domvetdoctor.util.ResultWrapper
import javax.inject.Inject

/**
 * Implementation of the [CityDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class CityRemoteDataStore @Inject constructor(private val cityRemote: CityRemote) :
    CityDataStore {

    override suspend fun getAllCities(): ResultWrapper<List<City>> {
        return cityRemote.getAllCities()
    }

}