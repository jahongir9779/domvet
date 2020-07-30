package com.sablab.domvetdoctor.models

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class DoctorAllInfo(
    val doctor: Doctor? = null,
    val reviews: List<Review> = emptyList(),
    val bios: List<Bio> = emptyList(),
    val rating: Rating? = null
)