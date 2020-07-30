package com.sablab.domvetdoctor.models

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class ChatDoctorInfo(
    @SerializedName("full_name") val fullName: String,
    @SerializedName("avatar") val avatar: String
)