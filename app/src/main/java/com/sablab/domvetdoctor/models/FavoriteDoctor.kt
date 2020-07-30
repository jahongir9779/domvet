package com.sablab.domvetdoctor.models

import com.google.gson.annotations.SerializedName

data class FavoriteDoctor(
    @SerializedName("id") val id: String? = "",
    @SerializedName("doctor") val doctor: Doctor? = null,
    @SerializedName("created_at") val createdAt: String? = ""
)