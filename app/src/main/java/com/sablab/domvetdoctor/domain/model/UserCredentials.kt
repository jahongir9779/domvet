package com.sablab.domvetdoctor.domain.model

import com.google.gson.annotations.SerializedName

data class UserCredentials(@SerializedName("phone_number") var phone_number: String,
                           @SerializedName("code") var code: Int,
                           @SerializedName("uid") var uid: String,
                           @SerializedName("type") var type: Int = 2
)

