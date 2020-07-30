package com.sablab.domvetdoctor.domain.model

import com.google.gson.annotations.SerializedName

data class Car(@SerializedName("id") var id: Long? = null,
               @SerializedName("modelId") var modelId: Long? = null,
               @SerializedName("imageId") var imageId: Long? = null,
               @SerializedName("fuelType") var fuelType: String? = null,
               @SerializedName("colorId") var colorId: Long? = null,
               @SerializedName("carNumber") var carNumber: String? = null,
               @SerializedName("carYear") var carYear: Int? = null,
               @SerializedName("airConditioner") var airConditioner: Boolean? = null,
               @SerializedName("imageList") var imageList: List<PhotoBody>? = arrayListOf())

