package com.sablab.domvetdoctor.domain.repository

import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.Filter
import com.sablab.domvetdoctor.domain.model.PassengerPost

interface PassengerPostRepository {

    suspend fun createPassengerPost(token: String, post: PassengerPost): ResultWrapper<String>
    suspend fun deletePassengerPost(token: String, identifier: String): ResultWrapper<String>
    suspend fun finishPassengerPost(token: String, identifier: String): ResultWrapper<String>
    suspend fun getActivePassengerPosts(token: String, lang: String): ResultWrapper<List<PassengerPost>>
    suspend fun getHistoryPassengerPosts(token: String, lang: String,
                                      page: Int): ResultWrapper<List<PassengerPost>>
}