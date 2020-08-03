package com.sablab.domvetdoctor.data

import com.sablab.domvetdoctor.data.source.CityDataStoreFactory
import com.sablab.domvetdoctor.domain.repository.CitiesRepository
import com.sablab.domvetdoctor.models.City
import com.sablab.domvetdoctor.util.ErrorWrapper
import com.sablab.domvetdoctor.util.ResultWrapper
import javax.inject.Inject

/**
 * Provides an implementation of the [CitiesRepository] interface for communicating to and from
 * data sources
 */
class CitiesRepositoryImpl @Inject constructor(private val factory: CityDataStoreFactory) :
    CitiesRepository {


    override suspend fun getAllCities(): ResultWrapper<List<City>> {

        val response =
            factory.retrieveDataStore(false).getAllCities()
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