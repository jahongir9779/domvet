package com.sablab.domvetdoctor.models.network

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NAddress(
    @SerializedName("id") val id: String? = "",
    @SerializedName("consumer_id") val consumer_id: String? = "",
    @SerializedName("name") val name: String? = "",
    @SerializedName("address") val address: String? = "",
    @SerializedName("latitude") val latitude: String? = "",
    @SerializedName("longitude") val longitude: String? = "",
    @SerializedName("landmark") val landmark: String? = "",
    @SerializedName("address_refinement_id") val address_refinement_id: String? = "",
    @SerializedName("addressRefinement") val addressRefinement: NAddressRefinement? = null
) : Parcelable {
    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<NAddress>() {
            override fun areItemsTheSame(oldItem: NAddress, newItem: NAddress): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: NAddress, newItem: NAddress): Boolean =
                oldItem.id == newItem.id && oldItem.address == newItem.address

        }
    }
}