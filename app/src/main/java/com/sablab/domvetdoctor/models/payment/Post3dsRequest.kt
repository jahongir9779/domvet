package com.sablab.domvetdoctor.models.payment

import com.google.gson.annotations.SerializedName


class Post3dsRequest(
    @SerializedName("transaction_id") val transactionId: String? = "",
    @SerializedName("pa_res") val paRes: String? = ""
)