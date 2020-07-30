package com.sablab.domvetdoctor.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Representation for a [LoginRequest] fetched from the API
 */
data class LoginRequest( @SerializedName("phone_number") val phone_number:String)