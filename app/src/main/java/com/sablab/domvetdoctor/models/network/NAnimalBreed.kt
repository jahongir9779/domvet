package com.sablab.domvetdoctor.models.network

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class NAnimalBreed(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String
)