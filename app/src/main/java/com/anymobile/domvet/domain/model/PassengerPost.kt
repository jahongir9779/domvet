package com.anymobile.domvet.domain.model
import com.anymobile.domvet.util.Constants
import com.google.gson.annotations.SerializedName

/**
 * Representation for a [PassengerPost] fetched from the API
 */
data class PassengerPost(@SerializedName("id") val id: Long?=null,
                         @SerializedName("from") val from: Place,
                         @SerializedName("to") val to: Place,
                         @SerializedName("price") val price: Int,
                         @SerializedName("departureDate") val departureDate: String,
                         @SerializedName("createdDate") val createdDate: String?=null,
                         @SerializedName("updatedDate") val updatedDate: String?=null,
                         @SerializedName("finishedDate") val finishedDate: String?=null,
                         @SerializedName("timeFirstPart") val timeFirstPart: Boolean,
                         @SerializedName("timeSecondPart") val timeSecondPart: Boolean,
                         @SerializedName("timeThirdPart") val timeThirdPart: Boolean,
                         @SerializedName("timeFourthPart") val timeFourthPart: Boolean,
                         @SerializedName("airConditioner") val airConditioner: Boolean?=null,
                         @SerializedName("remark") val remark: String,
                         @SerializedName("postStatus") val postStatus: String?=null,
                         @SerializedName("seat") val seat: Int,
                         @SerializedName("postType") val postType: String = Constants.PASSENGER_POST_SIMPLE)