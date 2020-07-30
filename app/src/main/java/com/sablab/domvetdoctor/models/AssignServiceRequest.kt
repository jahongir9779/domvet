package com.sablab.domvetdoctor.models

import com.google.gson.annotations.SerializedName

data class AssignServiceRequest(
    @SerializedName("services") val services: List<String>
)