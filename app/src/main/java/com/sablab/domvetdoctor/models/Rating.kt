package com.sablab.domvetdoctor.models

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("avgAllRating") val avgAllRating: Float? = 0f,
    @SerializedName("countReviews") val countReviews: Int? = 0,
    @SerializedName("five") val five: Int? = 0,
    @SerializedName("four") val four: Int? = 0,
    @SerializedName("three") val three: Int? = 0,
    @SerializedName("two") val two: Int? = 0,
    @SerializedName("one") val one: Int? = 0
)