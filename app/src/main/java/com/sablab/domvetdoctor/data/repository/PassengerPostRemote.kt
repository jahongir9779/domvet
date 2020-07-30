package com.sablab.domvetdoctor.data.repository

import com.sablab.domvetdoctor.domain.model.PassengerPost
import com.sablab.domvetdoctor.util.ResultWrapper

interface PassengerPostRemote {

    suspend fun createPassengerPost(token: String, post: PassengerPost): ResultWrapper<String>
    suspend fun deletePassengerPost(token: String, identifier: String): ResultWrapper<String>
    suspend fun finishPassengerPost(token: String, identifier: String): ResultWrapper<String>
    suspend fun getActivePassengerPosts(token: String,
                                     lang: String): ResultWrapper<List<PassengerPost>>

    suspend fun getHistoryPassengerPosts(token: String,
                                      lang: String,
                                      page: Int): ResultWrapper<List<PassengerPost>>



}