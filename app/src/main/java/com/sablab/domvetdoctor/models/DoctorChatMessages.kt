package com.sablab.domvetdoctor.models

import com.google.gson.annotations.SerializedName

data class DoctorChatMessages(
    @SerializedName("result") val messages: List<ChatMessage>,
    @SerializedName("doctorInfo") val doctorInfo: ChatDoctorInfo
)