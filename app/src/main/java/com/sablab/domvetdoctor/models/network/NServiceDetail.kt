package com.sablab.domvetdoctor.models.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NServiceDetail(
    @SerializedName("id") val id: String? = "",
    @SerializedName("name") val name: String? = ""
) : Parcelable