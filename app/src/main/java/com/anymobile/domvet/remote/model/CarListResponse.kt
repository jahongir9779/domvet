package com.anymobile.domvet.remote.model

import com.anymobile.domvet.domain.model.CarDetails
import com.google.gson.annotations.SerializedName

/**
 * Created by jahon on 12-Apr-20
 */
data class CarListResponse(val code: Int? = null,
                           val message: String? = null,
                           val data: List<CarDetails>? = null)

