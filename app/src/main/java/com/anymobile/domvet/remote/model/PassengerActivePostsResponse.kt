package com.anymobile.domvet.remote.model

import com.anymobile.domvet.domain.model.PassengerPost

/**
 * Created by jahon on 12-Apr-20
 */
data class PassengerActivePostsResponse(val code: Int? = null,
                                        val message: String? = null,
                                        val data: List<PassengerPost>? = null)

