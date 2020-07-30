package com.sablab.domvetdoctor.remote.model

import com.sablab.domvetdoctor.domain.model.PassengerPost

/**
 * Created by jahon on 12-Apr-20
 */
data class PassengerHistoryPostsResponse(val code: Int? = null,
                                         val message: String? = null,
                                         val data: PaginatedPost? = null)

data class PaginatedPost(val data: List<PassengerPost>? = null)