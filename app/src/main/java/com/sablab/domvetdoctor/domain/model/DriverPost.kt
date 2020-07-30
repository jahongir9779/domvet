package com.sablab.domvetdoctor.domain.model

import com.sablab.domvetdoctor.util.Constants
import com.google.gson.annotations.SerializedName

data class DriverPost(@SerializedName("id") val id: Long?=null,
                      @SerializedName("from") val from: Place,
                      @SerializedName("to") val to: Place,
                      @SerializedName("price") val price: Int,
                      @SerializedName("departureDate") val departureDate: String,
                      @SerializedName("finishedDate") val finishedDate: String?=null,
                      @SerializedName("timeFirstPart") val timeFirstPart: Boolean,
                      @SerializedName("timeSecondPart") val timeSecondPart: Boolean,
                      @SerializedName("timeThirdPart") val timeThirdPart: Boolean,
                      @SerializedName("timeFourthPart") val timeFourthPart: Boolean,
                      @SerializedName("carId") val carId: Long?=null,
                      @SerializedName("car") val car: CarInPost?=null,
                      @SerializedName("remark") val remark: String,
                      @SerializedName("seat") val seat: Int,
                      @SerializedName("postType") val postType: String = Constants.DRIVER_POST_SIMPLE)

