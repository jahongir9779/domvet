package com.sablab.domvetdoctor.data.repository

import com.sablab.domvetdoctor.domain.model.DriverPost
import com.sablab.domvetdoctor.domain.model.Filter
import com.sablab.domvetdoctor.domain.model.PassengerPost
import com.sablab.domvetdoctor.util.ResultWrapper


interface DriverPostDataStore {

    suspend fun filterDriverPost(token: String,
                                    lang: String,
                                    filter: Filter): ResultWrapper<List<DriverPost>>
}