package com.sablab.domvetdoctor.models

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
data class ServiceNameAndPrice(
    @SerializedName("name") val name: String? = null,
    @SerializedName("price") val price: BigDecimal? = BigDecimal.ZERO
) : Parcelable