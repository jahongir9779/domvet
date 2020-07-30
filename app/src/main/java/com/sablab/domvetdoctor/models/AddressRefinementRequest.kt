package com.sablab.domvetdoctor.models

import com.google.gson.annotations.SerializedName

data class AddressRefinementRequest(
    @SerializedName("address_id") val addressId: Int,
    @SerializedName("apartment") val apartment: Int? = null,
    @SerializedName("porch") val porch: Int? = null,
    @SerializedName("floor") val floor: Int? = null,
    @SerializedName("intercom") val intercom: Int? = null,
    @SerializedName("comment") val comment: String? = null
)
