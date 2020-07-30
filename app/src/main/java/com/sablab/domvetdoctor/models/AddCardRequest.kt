package com.sablab.domvetdoctor.models

import com.google.gson.annotations.SerializedName

data class AddCardRequest(
    @SerializedName("token") val token: String,
    @SerializedName("name") val name: String,
    @SerializedName("expire_at") val expire_at: String,
    @SerializedName("number") val number: String
)