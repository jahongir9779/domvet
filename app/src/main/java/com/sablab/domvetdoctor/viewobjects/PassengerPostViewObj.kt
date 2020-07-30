package com.sablab.domvetdoctor.viewobjects

import android.os.Parcelable
import com.sablab.domvetdoctor.util.Constants
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PassengerPostViewObj(val from: PlaceViewObj,
                                val to: PlaceViewObj,
                                val price: Int,
                                val departureDate: String,
                                val timeFirstPart: Boolean,
                                val timeSecondPart: Boolean,
                                val timeThirdPart: Boolean,
                                val timeFourthPart: Boolean,
                                val carId: Long?=null,
                                val car: CarViewObj?=null,
                                val remark: String,
                                val seat: Int,
                                val postType: String = Constants.PASSENGER_POST_SIMPLE) : Parcelable

@Parcelize
data class PlaceViewObj(val districtId: Int? = null,
                        val regionId: Int? = null,
                        val lat: Double? = null,
                        val lon: Double? = null,
                        val regionName: String? = null,
                        val name: String? = null) : Parcelable