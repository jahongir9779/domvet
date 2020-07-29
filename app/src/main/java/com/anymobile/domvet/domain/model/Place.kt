package com.anymobile.domvet.domain.model

import com.google.gson.annotations.SerializedName

data class Place(@SerializedName("districtId") val districtId: Int?=null,
                 @SerializedName("regionId") val regionId: Int?=null,
                 @SerializedName("lat") val lat: Double? = null,
                 @SerializedName("lon") val lon: Double? = null,
                 @SerializedName("regionName") val regionName: String? = null,
                 @SerializedName("districtName") val districtName: String? = null,
                 @SerializedName("name") val name: String? = null)