package com.sablab.domvetdoctor.models

import com.google.gson.annotations.SerializedName

data class NDay(
    @SerializedName("date") val date: String? = "",
    @SerializedName("name") val time: String? = "",
    @SerializedName("weekNumber") val weekNumber: String? = ""
)