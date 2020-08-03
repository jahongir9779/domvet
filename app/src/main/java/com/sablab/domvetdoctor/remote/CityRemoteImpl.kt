package com.sablab.domvetdoctor.remote

import com.sablab.domvetdoctor.data.repository.CityRemote
import com.sablab.domvetdoctor.models.City
import com.sablab.domvetdoctor.util.ErrorWrapper
import com.sablab.domvetdoctor.util.ResultWrapper
import javax.inject.Inject

/**
 * Remote implementation for retrieving Bufferoo instances. This class implements the
 * [BufferooRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class CityRemoteImpl @Inject constructor(private val apiService: ApiService) : CityRemote {

    override suspend fun getAllCities(): ResultWrapper<List<City>> {
        return try {
            val response = apiService.getAllCities()
            if (response.isSuccessful) {
                val cities = response.body()?.result?.map {
                    City(
                        cityId = it.cityId,
                        cityName = it.cityName,
                        citySlug = it.citySlug ?: "",
                        countryCode = it.countryCode ?: "",
                        regionId = it.regionId ?: "",
                        status = it.status ?: ""
                    )
                } ?: emptyList()
                ResultWrapper.Success(cities)
            } else ErrorWrapper.ResponseError(response.code(), response.errorBody()?.string())
        } catch (e: Exception) {
            ErrorWrapper.SystemError(e)
        }
    }
}