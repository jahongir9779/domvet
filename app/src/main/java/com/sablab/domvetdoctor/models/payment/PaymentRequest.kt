package com.sablab.domvetdoctor.models.payment

import com.google.gson.annotations.SerializedName

data class PaymentRequest(
    @SerializedName("cardCryptogramPacket") val cardCryptogramPacket: String? = "",
    @SerializedName("name") val name: String? = "",
    @SerializedName("ipAddress") val ipAddress: String? = ""

)