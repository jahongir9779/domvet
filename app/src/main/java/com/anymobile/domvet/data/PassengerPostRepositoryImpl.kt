package com.anymobile.domvet.data

import com.anymobile.domvet.data.source.PassengerPostDataStoreFactory
import com.anymobile.domvet.domain.model.Filter
import com.anymobile.domvet.domain.model.PassengerPost
import com.anymobile.domvet.domain.repository.PassengerPostRepository
import com.anymobile.domvet.domain.repository.PlaceRepository
import com.anymobile.domvet.util.ErrorWrapper
import com.anymobile.domvet.util.ResultWrapper
import javax.inject.Inject

/**
 * Provides an implementation of the [PlaceRepository] interface for communicating to and from
 * data sources
 */
class PassengerPostRepositoryImpl @Inject constructor(private val factoryPassenger: PassengerPostDataStoreFactory) :
    PassengerPostRepository {


    override suspend fun createPassengerPost(token: String, post: PassengerPost): ResultWrapper<String> {
        return factoryPassenger.retrieveDataStore(false)
            .createPassengerPost(token, post)
    }

    override suspend fun deletePassengerPost(token: String,
                                          identifier: String): ResultWrapper<String> {

        return factoryPassenger.retrieveDataStore(false).deletePassengerPost(token, identifier)
    }

    override suspend fun finishPassengerPost(token: String,
                                          identifier: String): ResultWrapper<String> {
        return factoryPassenger.retrieveDataStore(false).finishPassengerPost(token, identifier)

    }

    override suspend fun getActivePassengerPosts(token: String,
                                              lang: String): ResultWrapper<List<PassengerPost>> {
        val response =
            factoryPassenger.retrieveDataStore(false).getActivePassengerPosts(token, lang)

        return when (response) {
            is ErrorWrapper.ResponseError -> response
            is ErrorWrapper.SystemError -> response
            is ResultWrapper.Success -> {
                ResultWrapper.Success(response.value)
            }
            ResultWrapper.InProgress -> ResultWrapper.InProgress
        }
    }

    override suspend fun getHistoryPassengerPosts(token: String,
                                               lang: String,
                                               page: Int): ResultWrapper<List<PassengerPost>> {
        val response =
            factoryPassenger.retrieveDataStore(false).getHistoryPassengerPosts(token, lang, page)

        return when (response) {
            is ErrorWrapper.ResponseError -> response
            is ErrorWrapper.SystemError -> response
            is ResultWrapper.Success -> {
                ResultWrapper.Success(response.value)
            }
            ResultWrapper.InProgress -> ResultWrapper.InProgress
        }
    }




//    override suspend fun getHistoryPassengerPosts(token: String,
//                                               lang: String,
//                                               page: Int): ResultWrapper<List<PassengerPost>> {
//        val response =
//            factoryPassenger.retrieveDataStore(false).getHistoryPassengerPosts(token, lang,page)
//
//        return when (response) {
//            is ErrorWrapper.ResponseError -> response
//            is ErrorWrapper.SystemError -> response
//            is ResultWrapper.Success -> {
//                val posts = arrayListOf<PassengerPost>()
//                response.value.forEach { posts.add(driverPostMapper.mapFromEntity(it)) }
//                ResultWrapper.Success(posts)
//            }
//            ResultWrapper.InProgress -> ResultWrapper.InProgress
//        }
//    }


}