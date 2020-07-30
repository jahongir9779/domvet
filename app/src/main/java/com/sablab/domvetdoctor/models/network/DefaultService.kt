package com.sablab.domvetdoctor.models.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
data class DefaultService(
    @SerializedName("name") val name: String? = "",
    @SerializedName("price") val price: BigDecimal? = BigDecimal.ZERO
) : Parcelable