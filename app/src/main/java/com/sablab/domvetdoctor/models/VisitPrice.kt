package com.sablab.domvetdoctor.models

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class VisitPrice(
    @SerializedName("price_in_city") val priceInCity: BigDecimal? = BigDecimal.ZERO,
    @SerializedName("price_out_city") val priceOutCity: BigDecimal? = BigDecimal.ZERO
)