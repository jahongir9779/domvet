package com.sablab.domvetdoctor.remote

import com.sablab.domvetdoctor.util.ErrorWrapper
import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.data.repository.PassengerPostRemote
import com.sablab.domvetdoctor.domain.model.PassengerPost
import com.sablab.domvetdoctor.remote.model.HistoryPostRequest
import javax.inject.Inject

/**
 * Remote implementation for retrieving Bufferoo instances. This class implements the
 * [BufferooRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class PassengerPostRemoteImpl @Inject constructor(private val apiService: ApiService) :
    PassengerPostRemote {

    override suspend fun createPassengerPost(token: String,
                                          post: PassengerPost): ResultWrapper<String> {

        return try {
            val response = apiService.createPost(token, post)
            if (response.code == 1) {
                ResultWrapper.Success("SUCCESS")
            } else ErrorWrapper.ResponseError(response.code, response.message)
        } catch (e: Exception) {
            ErrorWrapper.SystemError(e)
        }
    }

    override suspend fun deletePassengerPost(token: String,
                                          identifier: String): ResultWrapper<String> {
        return try {
            val response = apiService.deletePost(token, identifier)
            if (response.code == 1) {
                ResultWrapper.Success("SUCCESS")
            } else ErrorWrapper.ResponseError(response.code, response.message)
        } catch (e: Exception) {
            ErrorWrapper.SystemError(e)
        }
    }

    override suspend fun finishPassengerPost(token: String,
                                          identifier: String): ResultWrapper<String> {
        return try {
            val response = apiService.finishPost(token, identifier)
            if (response.code == 1) {
                ResultWrapper.Success("SUCCESS")
            } else ErrorWrapper.ResponseError(response.code, response.message)
        } catch (e: Exception) {
            ErrorWrapper.SystemError(e)
        }
    }

    override suspend fun getActivePassengerPosts(token: String,
                                              lang: String): ResultWrapper<List<PassengerPost>> {

        return try {
            val response = apiService.getActivePosts(token, lang)
            if (response.code == 1) {
                ResultWrapper.Success(response.data!!)
            } else ErrorWrapper.ResponseError(response.code, response.message)
        } catch (e: Exception) {
            ErrorWrapper.SystemError(e)
        }
    }

    override suspend fun getHistoryPassengerPosts(token: String,
                                               lang: String,
                                               page: Int): ResultWrapper<List<PassengerPost>> {

        return try {
            val response = apiService.getHistoryPosts(token, lang, page)
            if (response.code == 1) {
                val posts = arrayListOf<PassengerPost>()
                response.data?.data?.forEach { posts.add(it) }
                ResultWrapper.Success(posts)
            } else ErrorWrapper.ResponseError(response.code, response.message)
        } catch (e: Exception) {
            ErrorWrapper.SystemError(e)
        }
    }


}