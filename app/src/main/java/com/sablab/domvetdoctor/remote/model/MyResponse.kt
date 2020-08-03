package com.sablab.domvetdoctor.remote.model
import com.google.gson.annotations.SerializedName

data class MyResponse<T>(
    @SerializedName("error") val errorCode: Int? = 0,
    @SerializedName("message") val message: String? = null,
    @SerializedName("result") val result: T? = null
)