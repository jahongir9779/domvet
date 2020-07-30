package com.sablab.domvetdoctor.models.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NAddressRefinement(
    @SerializedName("apartment") val apartment: String? = "",
    @SerializedName("porch") val porch: String? = "",
    @SerializedName("floor") val floor: String? = "",
    @SerializedName("intercom") val intercom: String? = "",
    @SerializedName("comment") val comment: String? = ""
) : Parcelable