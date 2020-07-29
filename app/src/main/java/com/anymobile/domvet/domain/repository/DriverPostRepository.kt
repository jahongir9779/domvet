package com.anymobile.domvet.domain.repository

import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.Filter
import com.anymobile.domvet.domain.model.DriverPost

interface DriverPostRepository {

   suspend fun filterDriverPost(token: String,
                                   lang: String,
                                   filter: Filter): ResultWrapper<List<DriverPost>>

}