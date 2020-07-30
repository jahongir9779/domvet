package com.sablab.domvetdoctor.models.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import com.sablab.domvetdoctor.models.payment.Card

@Parcelize
class NDiseaseDetail(
    @SerializedName("reason") val reason: NDiseaseReason? = null,
    @SerializedName("address") val address: NAddress? = null,
    @SerializedName("summary") val summary: String? = "",
    @SerializedName("defaultService") val defaultService: DefaultService? = null,
    @SerializedName("services") val services: List<NService>? = emptyList(),
    @SerializedName("card") val card: Card? = null
) : Parcelable