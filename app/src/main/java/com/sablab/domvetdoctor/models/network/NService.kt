package com.sablab.domvetdoctor.models.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
data class NService(
    @SerializedName("id") val id: String? = "",
    @SerializedName("doctor_id") val doctor_id: String? = "",
    @SerializedName("c_a_disease_id") val c_a_disease_id: String? = "",
    @SerializedName("service_id") val service_id: String? = "",
    @SerializedName("service_name") val service_name: String? = "",
    @SerializedName("type") val type: String? = "",
    @SerializedName("type_name") val type_name: String? = "",
    @SerializedName("service_price") val price: BigDecimal? = BigDecimal.ZERO
) : Parcelable