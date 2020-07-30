package com.sablab.domvetdoctor.models.network

import com.google.gson.annotations.SerializedName

data class NACTAnimalAndReason(
    @SerializedName("reason_id") val reasonId: String,
    @SerializedName("reason_text") val reason_text: String?

)