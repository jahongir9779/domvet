package com.sablab.domvetdoctor.domain.repository

import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.Filter
import com.sablab.domvetdoctor.domain.model.DriverPost

interface DriverPostRepository {

   suspend fun filterDriverPost(token: String,
                                   lang: String,
                                   filter: Filter): ResultWrapper<List<DriverPost>>

}