package com.anymobile.domvet.data.repository

import com.anymobile.domvet.domain.model.DriverPost
import com.anymobile.domvet.domain.model.Filter
import com.anymobile.domvet.domain.model.PassengerPost
import com.anymobile.domvet.util.ResultWrapper

interface DriverPostRemote {

    suspend fun filterDriverPost(token: String,
                                    lang: String,
                                    filter: Filter): ResultWrapper<List<DriverPost>>

}