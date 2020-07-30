package com.sablab.domvetdoctor.models

import com.google.gson.annotations.SerializedName

data class SearchDoctorResponce(
    @SerializedName("date") val date: String,
    @SerializedName("disease_id") val diseaseId: String
)