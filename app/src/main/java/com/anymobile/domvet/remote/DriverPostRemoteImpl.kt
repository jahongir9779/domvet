package com.anymobile.domvet.remote

import com.anymobile.domvet.data.repository.DriverPostRemote
import com.anymobile.domvet.util.ErrorWrapper
import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.DriverPost
import com.anymobile.domvet.domain.model.Filter
import javax.inject.Inject

/**
 * Remote implementation for retrieving Bufferoo instances. This class implements the
 * [BufferooRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class DriverPostRemoteImpl @Inject constructor(private val apiService: ApiService) :
    DriverPostRemote {

    override suspend fun filterDriverPost(token: String,
                                             lang: String,
                                             filter: Filter): ResultWrapper<List<DriverPost>> {
        return try {
            val response =
                apiService.filterDriverPost(token, lang, filter)
            if (response.code == 1) {
                ResultWrapper.Success(response.data!!.data!!)
            } else ErrorWrapper.ResponseError(response.code, response.message)
        } catch (e: Exception) {
            ErrorWrapper.SystemError(e)
        }
    }


}