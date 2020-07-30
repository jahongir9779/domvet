package com.sablab.domvetdoctor.models.network

import com.google.gson.annotations.SerializedName


/* "id": 408261,
    "name": "Сорочинск",
    "slug": "sorochinsk",
    "country_code": "ru",
    "status": 1,
    "region_id": 781878*/

data class NCity(
        @SerializedName("id") val cityId: String,
        @SerializedName("name") val cityName: String,
        @SerializedName("slug") val citySlug: String? = "",
        @SerializedName("county_code") val countryCode: String? = "",
        @SerializedName("status") val status: String? = "",
        @SerializedName("region_id") val regionId: String? = ""
)