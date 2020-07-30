package com.sablab.domvetdoctor.models.payment

import com.google.gson.annotations.SerializedName


class Transaction(
    // 3DS End
    @SerializedName("TransactionId") val id: String? = null,
    @SerializedName("ReasonCode") val reasonCode: Int? = 0,
    @SerializedName("CardHolderMessage") val cardHolderMessage: String? = null,
    // 3DS Begin
    @SerializedName("PaReq") val paReq: String? = null,
    @SerializedName("AcsUrl") val acsUrl: String? = null

)