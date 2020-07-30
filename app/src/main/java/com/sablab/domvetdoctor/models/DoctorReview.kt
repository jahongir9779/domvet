package com.sablab.domvetdoctor.models

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class DoctorReview(
    @SerializedName("doctor") val doctor: Doctor? = null,
    @SerializedName("reviews") val reviews: List<Review> = emptyList(),
    @SerializedName("rating") val rating: Rating? = null
)