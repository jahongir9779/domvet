package com.badcompany.pitakpass.remote

import com.badcompany.pitakpass.util.ErrorWrapper
import com.badcompany.pitakpass.util.ResultWrapper
import com.badcompany.pitakpass.data.model.PlaceEntity
import com.badcompany.pitakpass.data.repository.PlaceRemote
import com.badcompany.pitakpass.remote.mapper.PlaceMapper
import javax.inject.Inject

/**
 * Remote implementation for retrieving Bufferoo instances. This class implements the
 * [BufferooRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class PlaceRemoteImpl @Inject constructor(private val apiService: ApiService,
                                          private val placeMapper: PlaceMapper) : PlaceRemote {

    override suspend fun getPlacesAutocomplete(token: String,
                                               lang: String,
                                               queryString: String): ResultWrapper<List<PlaceEntity>> {
        return try {
            val response = apiService.getPlacesFeed(token, lang, queryString)
            if (response.code == 1) {
                val places = arrayListOf<PlaceEntity>()
                response.data!!.forEach {
                    places.add(placeMapper.mapToEntity(it))
                }
                ResultWrapper.Success(places)
            } else ErrorWrapper.ResponseError(response.code, response.message)
        } catch (e: Exception) {
            ErrorWrapper.SystemError(e)
        }
    }


}