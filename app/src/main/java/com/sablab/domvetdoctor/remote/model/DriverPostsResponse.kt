package com.sablab.domvetdoctor.remote.model

import com.sablab.domvetdoctor.domain.model.DriverPost
import com.sablab.domvetdoctor.domain.model.PassengerPost

/**
 * Created by jahon on 12-Apr-20
 */
data class DriverPostsResponse(val code: Int? = null,
                               val message: String? = null,
                               val data: DriverPostsPagination? = null)

data class DriverPostsPagination(val pages: Int? = null,
                                 val elements: Int? = null,
                                 val data: List<DriverPost>? = null)