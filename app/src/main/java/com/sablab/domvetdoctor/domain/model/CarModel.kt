package com.sablab.domvetdoctor.domain.model

import com.google.gson.annotations.SerializedName

data class CarModel (@SerializedName("id") val id: Long,
                     @SerializedName("name") val name: String)