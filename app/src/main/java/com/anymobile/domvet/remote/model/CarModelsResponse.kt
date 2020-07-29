package com.anymobile.domvet.remote.model

import com.anymobile.domvet.domain.model.CarModel

/**
 * Created by jahon on 12-Apr-20
 */
data class CarModelsResponse(val code: Int? = null,
                             val message: String? = null,
                             val data: List<CarModel>? = null
)


