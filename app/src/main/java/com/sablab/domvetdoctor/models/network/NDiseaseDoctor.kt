package com.sablab.domvetdoctor.models.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NDiseaseDoctor(
    @SerializedName("doctor_id") val doctorId: String? = "",
    @SerializedName("name") val name: String? = "",
    @SerializedName("photo") val photo: String? = "",
    @SerializedName("rating") val raiting: String? = ""
) : Parcelable