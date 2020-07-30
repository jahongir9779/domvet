package com.sablab.domvetdoctor.models.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NDiseaseReason(
    @SerializedName("selected") val selected: String? = "",
    @SerializedName("comment") val comment: String? = ""
) : Parcelable