package com.sablab.domvetdoctor.models

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal


/*"id": 1,
        "phone_number": 998946450615,
        "avatar": "http://domvet.sab-lab.com/uploads/doctor/avatars/1590213256.png",
        "token": "538a31c0-7a4c-11ea-9585-0242296032d7",
        "status": 1,
        "birth_date": "2020-01-01",
        "created_at": "Apr 9, 2020",
        "first_name": "1",
        "middle_name": "1",
        "last_name": "1",
        "passport": "1590213454,9709.jpg",
        "passport_registration": "1590213454,971.jpg",
        "email": "muxawa@gmail.com",
        "region_id": 781839,
        "city_id": 407400,
        "commission": null,
        "balance": null,
        "status_name": "Активный",
        "full_name": "1 1 1",*/
@Parcelize
data class Doctor(
    @SerializedName("id") val id: String? = "",
    @SerializedName("phone_number") val phoneNumber: String? = "",
    @SerializedName("avatar") val avatar: String? = "",
    @SerializedName("birth_date") val birthDate: String? = "",
    @SerializedName("first_name") val firstName: String? = "",
    @SerializedName("middle_name") val middleName: String? = "",
    @SerializedName("last_name") val lastName: String? = "",
    @SerializedName("email") val email: String? = "",
    @SerializedName("full_name") val fullName: String? = "",
    @SerializedName("last_visit_date") val lastVisitDate: String? = "",
    @SerializedName("visit_count") val visitCount: String? = "",
    @SerializedName("visit_price") val visitPrice: Int? = 0,
    @SerializedName("isFavourite") val isFavorite: Boolean? = false,
    @SerializedName("doctor_job") val job: String? = "",
    @SerializedName("doctor_workplace") val workPlace: String? = "",
    @SerializedName("rating") val rating: Float? = 0f,
    @SerializedName("rating_count") val ratingCount: Int? = 0
) : Parcelable {
    companion object {
        val DIFF_UTILL = object : DiffUtil.ItemCallback<Doctor>() {
            override fun areItemsTheSame(oldItem: Doctor, newItem: Doctor) = oldItem == newItem

            override fun areContentsTheSame(oldItem: Doctor, newItem: Doctor) =
                oldItem.id == newItem.id && oldItem.isFavorite == newItem.isFavorite

        }
    }
}