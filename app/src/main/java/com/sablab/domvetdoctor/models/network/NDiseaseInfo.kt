package com.sablab.domvetdoctor.models.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class NDiseaseInfo(
    @SerializedName("reason") val reason: NDiseaseReason? = null,
    @SerializedName("address") val address: NAddress? = null,
    @SerializedName("summary") val summary: String? = "",
    @SerializedName("services") val services: String? = ""
) : Parcelable