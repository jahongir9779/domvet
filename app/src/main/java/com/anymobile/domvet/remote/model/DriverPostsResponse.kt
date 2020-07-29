package com.anymobile.domvet.remote.model

import com.anymobile.domvet.domain.model.DriverPost
import com.anymobile.domvet.domain.model.PassengerPost

/**
 * Created by jahon on 12-Apr-20
 */
data class DriverPostsResponse(val code: Int? = null,
                               val message: String? = null,
                               val data: DriverPostsPagination? = null)

data class DriverPostsPagination(val pages: Int? = null,
                                 val elements: Int? = null,
                                 val data: List<DriverPost>? = null)