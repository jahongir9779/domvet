package com.sablab.domvetdoctor.models

import com.google.gson.annotations.SerializedName

data class DayTime(
    @SerializedName("date") val date: String? = "",
    @SerializedName("time") val time: String? = "",
    @SerializedName("disease_id") val disease_id: String? = ""
)