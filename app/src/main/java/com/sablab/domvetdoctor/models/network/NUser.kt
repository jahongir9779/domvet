package com.sablab.domvetdoctor.models.network

import com.google.gson.annotations.SerializedName

data class NUser(
    @SerializedName("phone_number") val phoneNumber: String,
    @SerializedName("token") var token: String,
    @SerializedName("status") var status: String,
    @SerializedName("created_at") var createdAt: String,
    @SerializedName("id") var id: String,
    @SerializedName("avatar") var avatar: String? = null,
    @SerializedName("birth_date") var birthDate: String? = null,
    @SerializedName("first_name") var firstName: String? = null,
    @SerializedName("middle_name") var middleName: String? = null,
    @SerializedName("last_name") var lastName: String? = null,
    @SerializedName("passport") var passport: String? = null,
    @SerializedName("passport_registration") var passportRegistration: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("region_id") var regionId: String? = null,
    @SerializedName("city_id") var cityId: String? = null,
    @SerializedName("addresses") var addresses: List<NAddress>? = null
)