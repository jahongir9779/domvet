package com.sablab.domvetdoctor.models

import com.google.gson.annotations.SerializedName

data class DoctorBio(
    @SerializedName("doctor") val doctor: Doctor? = null,
    @SerializedName("bio") val bios: List<Bio>? = emptyList()
)