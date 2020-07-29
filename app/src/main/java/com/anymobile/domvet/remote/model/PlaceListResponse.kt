package com.anymobile.domvet.remote.model

import com.anymobile.domvet.domain.model.Place

/**
 * Created by jahon on 12-Apr-20
 */
data class PlaceListResponse(val code: Int? = null,
                             val message: String? = null,
                             val data: List<Place>? = null)

