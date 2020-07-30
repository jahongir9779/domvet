package com.sablab.domvetdoctor.models.payment

import com.google.gson.annotations.SerializedName

/* {
        "date": "2020-07-24 17:09:05.000000",
        "timezone_type": 3,
        "timezone": "UTC"
    }
    */

data class PaymentDate(
    @SerializedName("date") val date: String? = null,
    @SerializedName("timezone_type") val timezone_type: String? = null,
    @SerializedName("timezone") val timezone: String? = null
)