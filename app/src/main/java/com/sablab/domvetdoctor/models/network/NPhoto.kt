package com.sablab.domvetdoctor.models.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NPhoto(
    @SerializedName("file") val file: String? = ""
) : Parcelable