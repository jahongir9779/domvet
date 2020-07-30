package com.sablab.domvetdoctor.models

import com.google.gson.annotations.SerializedName

data class SendMessage(
    @SerializedName("consumer_id") val consumerId: String,
    @SerializedName("sender") val sender: String,
    @SerializedName("message") val message: String
)